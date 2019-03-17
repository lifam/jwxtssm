$(document).ready(function () {
    if (!$.cookie("headImg")) {
        $.cookie("headImg", "/getHeadImg" + "?no-cache-value=" + Math.random(), {path:"/"});
    }
    $("#headImg").attr("src", $.cookie("headImg"));

    $("#clearCookies").click(function () {
        $.cookie("set", null);
        $.cookie("state", null);
        $.cookie("authCodes", null);
        $.cookie("headImg", "/getHeadImg" + "?no-cache-value=" + Math.random(), {path:"/"});
        location.reload();
    });

    if ($.cookie("set") != "true") {
        $.ajax({
            type: "POST",
            url: "/home",
            dataType: "json",
            async: "true",
            success: function (data) {
                data = eval(data);
                // $("#debug").text(data);
                if (data["state"] == "success") {
                    $("#login").hide();
                    $("#logout").show();
                    $("#personalPage").show();
                    txt = "";
                    for (i in data["authCodes"]) {
                        if (data["authCodes"][i] == 1) $(".admin").show();
                        else if (data["authCodes"][i] == 2) $(".officer").show();
                        else if (data["authCodes"][i] == 3) $(".teacher").show();
                        else if (data["authCodes"][i] == 4) $(".teacher-assist").show();
                        else if (data["authCodes"][i] == 5) $(".student").show();

                        txt += data["authCodes"][i] + ','
                    }
                    $.cookie("authCodes", txt, {path:"/"});
                }
                $.cookie("set", "true", {path:"/"});
                $.cookie("state", data["state"], {path:"/"});


            }
        });
    } else {
        if ($.cookie("state") == "success") {
            $("#login").hide();
            $("#logout").show();
            $("#personalPage").show();
            authCodes = $.cookie("authCodes").split(',');
            for (i in authCodes) {
                if (authCodes[i] == '1') $(".admin").show();
                else if (authCodes[i] == '2') $(".officer").show();
                else if (authCodes[i] == '3') $(".teacher").show();
                else if (authCodes[i] == '4') $(".teacher-assist").show();
                else if (authCodes[i] == '5') $(".student").show();
            }
        }
    }

});