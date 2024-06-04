let us = doclocalStorage();
if (us == null) {
    window.location.href = "../login/logins.html"
}
let token = us.token;
showAllCompter();
function showAllCompter() {
    $.ajax({
        headers: {
            "Authorization": "Bearer " + token
        },
        method: "get",
        url: "http://localhost:8080/api/computers",
        success: function (data) {
            let arrComputer = data.map((c, i, arrc) => {
                return `
            <tr>
                <th>${c.id}</th>
                <th>${c.code}</th>
                <th>${c.name}</th>
                <th>${c.producer}</th>
                <th>${c.type}</th>
                <th>
                <a href="javascript:void(0)" onclick="computerDelete(${c.id})">Delete</a>
                <a href="javascript:void(0)" onclick="showFormUpdate(${c.id})">Update</a>
                </th>
             </tr>
            `;
            })
            $("#tb-computer").html(arrComputer.join(""))
        }
    })

}
function showformCreate(){
    $("#form1").show();
    $("#table").hide();
    $("#create").hide();
}
function hideFormCreate(){
    $("#form1").hide();
    $("#table").show();
}
function createNewComputer(){
    let name = document.getElementById("name").value
    let code = document.getElementById("code").value
    let producer = document.getElementById("producer").value
    let type = document.getElementById("type").value
    $.ajax({
        headers: {
            "Authorization": "Bearer " + token
        },
        method: "post",
        url: "http://localhost:8080/api/computers",
        contentType: "application/json",
        data: JSON.stringify({
            "name": name,
            "code": code,
            "producer": producer,
            "type": type
        }),
        success: function (data){
            showAllCompter()
            $("#form1").hide();
            $("#table").show();
        }
    })
}

function doclocalStorage() {
    let str = localStorage.getItem("user")
    let users = JSON.parse(str)
    return users
}
function computerDelete(id){
$.ajax({
    headers: {
        "Authorization": "Bearer " + token
    },
    method: "delete",
    url: "http://localhost:8080/api/computers/" +id,
    success: function (){
        showAllCompter()
    }
})
}
function showFormUpdate(id){
    $.ajax({
        headers: {
            "Authorization": "Bearer " + token
        },
        method: "get",
        url: "http://localhost:8080/api/computers/" +id,
        success: function (data){

            let strFrmUpdate =  `
            <table>
                <tr>
                <td><label for="code1">CODE</label></td>
                    <td><input id="code1" type="text" placeholder="" value="${data.code}"></td>
                </tr>
                <tr>
                <td><label for="name1">NAME</label></td>
                    <td><input id="name1" type="text" placeholder="" value="${data.name}"></td>
                </tr>
                <tr>
                <td><label for="producer1">PRODUCER</label></td>
                    <td> <input id="producer1" type="text" placeholder="" value="${data.producer}"></td>
                </tr>
                <tr>
                <td><label for="type1">TYPE</label></td>
                    <td><select name = "type" id="type1">
                            <option value="IOS">IOS</option>
                             <option value="WINDOW">WINDOW</option>
                        </select>
                    </td>
                </tr>
            </table>
            
           
            
            <button type="button" onclick="updateComputer(${data.id})">Save</button>
            <button onclick="getAllComputer()">Cancel</button>
            `;
            $("#form2").html(strFrmUpdate);
            $("#form2").show();
            $("#table").hide();
            $("#create").hide();

        }
    })
}
function updateComputer(id){
    let name = document.getElementById("name1").value
    let code = document.getElementById("code1").value
    let producer = document.getElementById("producer1").value
    let type = document.getElementById("type1").value
    $.ajax({
        headers: {
            "Authorization": "Bearer " + token
        },
        method: "put",
        url: "http://localhost:8080/api/computers/" +id,
        contentType: "application/json",
        data: JSON.stringify({
            "name": name,
            "code": code,
            "producer": producer,
            "type": type
        }),
        success: function (){
            showAllCompter()
            $("#form2").hide();
        }
    })
}