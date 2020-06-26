$('#btn-apply-job').on('click',function () {
    Swal.fire({
        title: 'Bạn chắc chắn muốn ứng tuyển công việc này?',
        text: "Nhà tuyển dụng sẽ xem được profile của bạn sau khi ứng tuyển",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Ứng tuyển ngay!',
        cancelButtonText: 'Hủy bỏ'
    }).then((result) => {
        if (result.value) {
            applyJob();
        }
    })
});

function applyJob(){
    var data = {
        user :{
            id : $('#userId').val()
        },
        post:{
            id : $('#postId').val()
        }
    }
    var url = $('#url-apply-job').attr('href');
    $.ajax({
        url: url,
        type: 'post',
        contentType: 'application/json',
        data : JSON.stringify(data),
        dataType : 'json',
        cache: false,
        success: function (res) {
            console.log(res);
            if(res.id!=null){
                Swal.fire(
                    'Thành công!',
                    'Vui lòng đợi phản hồi từ nhà tuyển dụng.',
                    'success'
                )
            }
        },
        error: function (res) {
            console.log(res);
        }
    })
}