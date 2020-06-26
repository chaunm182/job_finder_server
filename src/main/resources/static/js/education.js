$('#modal').on('click','#btn-save-education',function () {
    var data = {}
    data['schoolName'] = $('#schoolName').val();
    data['startAt'] = $('#startAt').val();
    data['endAt'] = $('#endAt').val();
    data['description'] = $('#description').val();
    data['profile'] = {
        id : $('#profile-id').val()
    };
    var url = $('#url-education').attr('href');
    $.ajax({
        url: url,
        type : 'post',
        contentType : 'application/json',
        data :JSON.stringify(data),
        cache: false,
        dataType: 'json',
        success : function (res) {
            if(typeof res.id !== undefined){
                $(location).attr('href','/profile');
            }
        },
        error: function (res) {
            console.log(res);
        }
    })
});

function deleteEducation(btn) {
    var id = $(btn).attr('education-id');
    var url = $('#url-education').attr('href');
    url+='/'+id;
    $.ajax({
        url: url,
        type : 'delete',
        cache: false,
        success : function (res) {
                $(location).attr('href','/profile');
        },
        error: function (res) {
            console.log(res);
        }
    })
}