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
