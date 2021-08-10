function displayContent(){
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/ServletsAsync_3C_war/readGames'
    }).done(function (res){
        let listGames  = res.listGames
        for (let game of listGames){
            document.getElementById("body").innerHTML += '<tr><td>' + game.name + '</td><td>' + game.datePremiere +  '</td><td><img src="data:image/jpeg;base64,'+game.imgGame+'" class="img-fluid rounded-start" style="height: 150px; width: 200px">' + '</td><td>' + game.Category_idCategory.name + '</td><td>' + game.status+ '</td></tr>';
            }
    })
}

 function createGame(){
    let name = document.getElementById("nameGame").value;
    let image = document.getElementById("img").value;
    let date = document.getElementById("datePremiere").value;
    let category = document.getElementById("category").value;
    //let data = JSON.parse(id);
    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/ServletsAsync_3C_war/createGames',
        contentType: 'multipart/form-data',
        data: {
            action: 'create',
            name: name,
            image: image,
            date: date,
            idCategory: category
        }
    }).done(function(res){ // done recibir lo que nos manda el Servlet
        console.log(res);
        let message = res.message;

    });
};

