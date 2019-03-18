$(document).ready(function () {
    if (!Cookies.get("headImg")) {
        Cookies.set("headImg", "/getHeadImg" + "?no-cache-value=" + Math.random(), {path:"/"});
    }
    $("#headImg").attr("src", Cookies.get("headImg"));

    $("#clearCookies").click(function () {
        Cookies.remove("set");
        Cookies.remove("state");
        Cookies.remove("authCodes");
        Cookies.set("headImg", "/getHeadImg" + "?no-cache-value=" + Math.random(), {path:"/"});
        location.reload();
    });

    if (Cookies.get("set") != "true") {
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
                    Cookies.set("authCodes", txt, {path:"/"});
                }
                Cookies.set("set", "true", {path:"/"});
                Cookies.set("state", data["state"], {path:"/"});
            }
        });
    } else {
        if (Cookies.get("state") == "success") {
            $("#login").hide();
            $("#logout").show();
            $("#personalPage").show();
            authCodes = Cookies.get("authCodes").split(',');
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