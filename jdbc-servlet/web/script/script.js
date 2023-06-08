/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function send() {
    var arr = document.getElementsByTagName('input');
    let username = arr[0].value;
    let password = arr[1].value;
    let confirm = arr[2].value;
    let fullName = arr[3].value;
    if (username.trim().length < 6 || username.trim().length > 20) {
        alert("Username length requires 6 - 20 characters");
    }
    if (password.trim().length < 6 || password.trim().length > 30) {
        alert("Password length requires 6 - 30 characters");
    } else if (confirm.trim() !== password.trim()) {
        alert("Confirm must match password");
    }

    if (fullName.trim().length < 2 || fullName.trim().length > 50) {
        alert("Full length requires 2 - 50 characters");
    }
}


