$(function () {
    var $infoTableForm = $(".info-table-form");
    var settings = {
        url: ctx + "info/list",
        pageSize: 10,
        queryParams: function (params) {
            return {
                pageSize: params.limit,
                pageNum: params.offset / params.limit + 1,
                name: $infoTableForm.find("input[name='name']").val().trim(),
                infoType: $infoTableForm.find("select[name='infoType']").val()
            };
        },
        columns: [{
            checkbox: true
        }, {
            field: 'infoId',
            visible: false
        }, {
            field: 'name',
            title: '标题'
        }, {
        	field: 'infoTypeName',
            title: '类别'
        }, {
            field: 'crateTime',
            title: '创建时间'
        }
        ]
    };
    $MB.initTable('infoTable', settings);
});

function search() {
    $MB.refreshTable('infoTable');
}

function refresh() {
    $(".info-table-form")[0].reset();
    $MB.refreshTable('infoTable');
}

function deleteInfos() {
    var selected = $("#infoTable").bootstrapTable('getSelections');
    var selected_length = selected.length;
    var contain = false;
    if (!selected_length) {
        $MB.n_warning('请勾选需要删除的信息！');
        return;
    }
    var ids = "";
    for (var i = 0; i < selected_length; i++) {
        ids += selected[i].infoId;
        if (i !== (selected_length - 1)) ids += ",";
        if (name === selected[i].name) contain = true;
    }
    if (contain) {
        $MB.n_warning('勾选用户中包含当前登录用户，无法删除！');
        return;
    }

    $MB.confirm({
        text: "确定删除选中信息？",
        confirmButtonText: "确定删除"
    }, function () {
        $.post(ctx + 'info/delete', {"ids": ids}, function (r) {
            if (r.code === 0) {
                $MB.n_success(r.msg);
                refresh();
            } else {
                $MB.n_danger(r.msg);
            }
        });
    });
}