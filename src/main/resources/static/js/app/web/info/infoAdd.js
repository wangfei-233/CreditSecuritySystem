var $infoAddForm = $("#info-add-form");
var ue = UE.getEditor('editor');

$(function () {
    $("#info-add .btn-save").click(function () {
        var name = $(this).attr("name");
        var flag = validator.form();
        if (flag) {
            if (name === "save") {
                $.post(ctx + "info/add", $infoAddForm.serialize(), function (r) {
                    if (r.code === 0) {
                        closeModal();
                        $MB.n_success(r.msg);
                        $MB.refreshTable("infoTable");
                    } else $MB.n_danger(r.msg);
                });
            }
            if (name === "update") {
                $.post(ctx + "info/update", $infoAddForm.serialize(), function (r) {
                    if (r.code === 0) {
                        closeModal();
                        $MB.n_success(r.msg);
                        $MB.refreshTable("infoTable");
                    } else $MB.n_danger(r.msg);
                });
            }
        }
    });

    $("#info-add .btn-close").click(function () {
        closeModal();
    });

});

function closeModal() {
    // $("#info-add-button").attr("name", "save");
    // validator.resetForm();
    // $typesSelect.multipleSelect('setSelects', []);
    // $typesSelect.multipleSelect("refresh");
    // $infoAddForm.find("input[name='infoname']").removeAttr("readonly");
    // $infoAddForm.find(".info_password").show();
    // $infoAddForm.find("input[name='status']").prop("checked", true);
    // $("#info-add-modal-title").html('新增用户');
    // $("#status").html('可用');
    // $MB.resetJsTree("deptTree");
    $MB.closeAndRestModal("info-add");
}