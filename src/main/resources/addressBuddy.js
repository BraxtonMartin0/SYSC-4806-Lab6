var table = document.getElementById("buddies");
var submitbutton = document.getElementById("submit");

var addressBookItem = null;
createNewAddressBook();

function createAddressBook(){
    $.ajax({
        url: "/addressBookCreate"
        }).then(function(data){
        $('#console').append("Your AddressBook ID: " + data.id)
        });
    }

function addNewBuddy(e) {
    $.ajax({
        url: "/buddyInfoAdd",
        data:{
            name: $('#buddyInfoName').val(),
            phone: $('#buddyInfoPhoneNumber').val(),
            address: $('#buddyInfoAddress').val()
            ID: $('#buddyInfoID').val()
        }
        }).then(function (data) {
            $('#console').append(data.name + "added to AddressBook with ID:" +
            data.id);
        });
}

function displayBook(){
    $.ajax({
        url: "/adBookDisplay",
        data: {ID: $('#Book').val()
        }
    }).then(function (data){
        $("#console").append("AddressBook: " + data.id + "<br>");
        let buddy = "";

        for(let i=0; i<data.buddies.length; i++){
            buddy += "Name: " + data.buddies[i].name;
            buddy += "Address: " + data.buddies[i].address;
            buddy += "Phone Number:" + data.buddies[i].phone;
            buddy += "<br>";
        }
        $('#console').append(buddyString);
    });
}