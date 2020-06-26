
$('#btn-add-subscriber').on('click',function () {
    var url  = $('#url-subscriber').attr('href');
    var data = {};
    var userId = $('#user-id').val();
    var jobCategoryId = $('#jobCategory').val();
    data['user'] = {
        id : userId
    };
    data['jobCategory'] = {
        id : jobCategoryId
    }
    if(isSubscriberExist(url,userId,jobCategoryId)) {
        Swal.fire(
            'Lỗi',
            'Bạn đã subscribe ngành nghề này',
            'error'
        );
    }
    else{
        addSubscriber(url,data);
    }


})

function isSubscriberExist(url,userId,jobCategoryId) {
    var result = false;
    $.ajax({
        url : url+'/'+userId+','+jobCategoryId,
        type : 'get',
        dataType : 'json',
        data: '',
        async: false,
        success : function (res) {
            if(res.id!=null){
                console.log(res);
                result = true;
            }
        },
        error: function (res) {
            console.log('error:');
        }
    });
    return result;
}

function addSubscriber(url,data) {
    $.ajax({
        url : url,
        type : 'post',
        contentType : 'application/json',
        dataType : 'json',
        data : JSON.stringify(data),
        cache: false,
        success : function (res) {
            if(res.id!=null){
                Swal.fire(
                    'Thành công!',
                    '',
                    'success'
                ).then((result)=>{
                    $(location).attr('href','/subscriber');
                });
            }
        },
        error: function (res) {
            console.log('error:');
            console.log(res)
        }
    });
}

function deleteById(btn) {
    var button = $(btn);
    var id = button.attr('subscriber-id');
    $.ajax({
        url : $('#url-subscriber').attr('href')+'/'+id,
        type : 'delete',
        dataType : 'text',
        data: '',
        success : function (res) {
            if(res==='true'){
                Swal.fire(
                    'Thành công!',
                    '',
                    'success'
                ).then((result)=>{
                    $(location).attr('href','/subscriber');
                });
            }
        },
        error: function (res) {
            console.log('error:');
            console.log(res)
        }
    });
}