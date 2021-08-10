package mx.edu.utez.modal.games;

import mx.edu.utez.modal.category.BeanCategory;
import mx.edu.utez.service.ConnectionMySQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class DaoGames {
    private Connection con;
    private CallableStatement cstm;
    private ResultSet rs;
    final private Logger CONSOLE = LoggerFactory.getLogger(DaoGames.class);

    public List<BeanGames> findAll(){
        List<BeanGames> listGames = new ArrayList<>();
        try {
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call sp_findGames}");
            rs = cstm.executeQuery();

            while (rs.next()){
                BeanCategory beanCategory = new BeanCategory();
                BeanGames beanGames = new BeanGames();

                beanCategory.setIdCategory(rs.getInt("idCategory"));
                beanCategory.setName(rs.getString("nameCategory"));
                beanCategory.setStatus(rs.getInt("status"));

                beanGames.setIdGames(rs.getInt("idGames"));
                beanGames.setName(rs.getString("name"));
                byte[] imgBytes = rs.getBytes("img_game");
                beanGames.setImgGame(Base64.getEncoder().encodeToString(imgBytes));
                beanGames.setDatePremiere(rs.getString("date_premiere"));
                beanGames.setStatus(rs.getInt("status"));
                beanGames.setCategory_idCategory(beanCategory);

                listGames.add(beanGames);
            }
        }catch (SQLException e) {
            CONSOLE.error("Ha ocurrido un error: " + e.getMessage());
        }finally {
            ConnectionMySQL.closeConnection(con, cstm, rs);
        }
        return listGames;
    }
    public BeanGames findById(int id){
        BeanGames beanGames = null;
        try {
            // SELECT * FROM users AS U INNER JOIN persons AS P ON U.idPerson = P.id INNER JOIN roles AS R ON U.idRole = R.id;
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call.sp_findById}");
            cstm.setLong(1, id);
            rs = cstm.executeQuery();

            if(rs.next()){
                BeanCategory beanCategory = new BeanCategory();
                beanGames = new BeanGames();

                beanCategory.setIdCategory(rs.getInt("idCategory"));
                beanCategory.setName(rs.getString("nameCategory"));
                beanCategory.setStatus(rs.getInt("status"));

                beanGames.setIdGames(rs.getInt("idGames"));
                beanGames.setName(rs.getString("name"));
                byte[] imgBytes = rs.getBytes("img_game");
                beanGames.setImgGame(Base64.getEncoder().encodeToString(imgBytes));
                beanGames.setDatePremiere(rs.getString("date_premiere"));
                beanGames.setStatus(rs.getInt("status"));
                beanGames.setCategory_idCategory(beanCategory);
            }
        }catch (SQLException e){
            CONSOLE.error("Ha ocurrido un error: " + e.getMessage());
        } finally {
            ConnectionMySQL.closeConnection(con, cstm, rs);
        }
        return beanGames;
    }
    public boolean create(BeanGames games, InputStream image){
        boolean flag = false;
        try{
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call sp_create(?,?,?,?,?)}");
            cstm.setString(1, games.getName());
            cstm.setBlob(2, image);
            cstm.setString(3, games.getDatePremiere());
            cstm.setInt(4, games.getCategory_idCategory().getIdCategory());
            cstm.execute();
            flag = true;
        }catch(SQLException e){
            CONSOLE.error("Ha ocurrido un error: " + e.getMessage());
        } finally {
            ConnectionMySQL.closeConnection(con, cstm);
        }
        return flag;
    }

    public boolean update(BeanGames games){
        boolean flag = false;
        try{
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call sp_update(?,?,?,?,?)}");
            cstm.setInt(1, games.getIdGames());
            cstm.setString(2, games.getName());
            cstm.setBytes(3, Base64.getDecoder().decode(games.getImgGame()));
            cstm.setString(4, games.getDatePremiere());
            cstm.setInt(5, games.getCategory_idCategory().getIdCategory());
            flag = cstm.execute();
        }catch(SQLException e){
            CONSOLE.error("Ha ocurrido un error: " + e.getMessage());
        }finally{
            ConnectionMySQL.closeConnection(con, cstm);
        }
        return flag;
    }

    public boolean delete(int idGames){
        boolean flag = false;
        try{
            System.out.println(idGames);
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call sp_delete(?)}");
            cstm.setLong(1, idGames);

            flag = cstm.execute();
        }catch(SQLException e){
            CONSOLE.error("Ha ocurrido un error: " + e.getMessage());
        }finally{
            ConnectionMySQL.closeConnection(con, cstm);
        }
        return flag;
    }
}
