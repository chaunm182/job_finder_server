$('#btn-search-job').on('click',function () {
    var form = $('#form-search-job');
    var data = form.serialize();
    var url = form.attr('action');

    $.ajax({
        url : url,
        type : 'get',
        data : data,
        dataType: 'json',
        success: function (res) {
            $('#search-title').text('Kết quả tìm kiếm: "'+$('#jobName').val()+'"');
            var tbody = $('#search-table');
            tbody.html('');
            var rows = drawRows(res);
            tbody.append(rows);
        },
        error: function (res) {
            console.log("error");
            console.log(res);
        }
    })
});

function drawRows(items) {
    var rows = '';
    $.each(items,function (index,item) {
       var row = '<tr>\n' +
           '       <td>\n' +
           '        <div class="table-data__info">\n' +
           '          <h5>\n' +
           '           <a href="#">'+item.jobName+'</a>\n' +
           '          </h5>\n' +
           '         <span>\n' +
           '            <a>'+item.company.name+'</a>\n' +
           '          </span>\n' +
           '        </div>\n' +
           '         </td>\n' +
           '        <td>'+item.minSalary+'</td>\n' +
           '        <td>'+item.maxSalary+'</td>\n' +
           '         <td>\n' +
           '         <span class="role user">'+item.address+'</span>\n' +
           '        </td>\n' +
           '    </tr>'
        rows+=row;
    });
    return rows;
}