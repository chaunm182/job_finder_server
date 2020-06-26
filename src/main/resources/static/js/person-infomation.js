$('#modal').on('click','#btn-save-person-info',function () {
    var data = {}
    data['id'] = $('#userId').val();
    data['fullName'] = {
        id : $('#fullNameId').val(),
        firstName : $('#firstName').val(),
        lastName : $('#lastName').val()
    }

    data['phone'] = $('#phone').val();
    data['description'] = $('#description').val();
    data['account'] = {
        id : $('#accountId').val()
    }
    data['profile'] = {
        id : $('#profileId').val(),
        position : $('#position').val(),
    };
    var addressId = $('#addressId').val();
    data['address']={};
    if(addressId!==""){
        data['address']['id'] = addressId;
    }
    data['address']['addressDetail'] = $('#addressDetail').val();
    data['address']['street'] = $('#street').val();
    data['address']['district'] = $('#district').val();
    data['address']['city'] = $('#city').val();
    var url = $('#form-update-infomation').attr('action');
    $.ajax({
        url: url,
        type : 'put',
        contentType : 'application/json',
        data :JSON.stringify(data),
        dataType: 'text',
        cache: false,
        success : function (res) {

                $(location).attr('href','/profile');

        },
        error: function (res) {
            console.log('error:');
           console.log(res);
        }
    })
});
