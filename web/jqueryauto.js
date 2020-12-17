var highlightindex=-1;
var timeoutId;
$(document).ready(function () {
    var wordInput=$("#word");
    var wordInputoffset=wordInput.offset();
    $("#auto").hide().css("border","lpx black solid").css("position","absolute").css("top",wordInput.height()+"px")
        .css("left",wordInputoffset.left+"px")
        .width(wordInput.width()+1);

    //给文本框添加键盘按下并弹起的时间
    wordInput.keyup(function (event) {
        var myEvent=event||window.event;
        var keyCode=myEvent.keyCode;


        if(keyCode>=65&&keyCode<=90||keyCode==8||keyCode==46)
        {
            //获取文本框内容
            var wordText=$("#word").val();
            var autoNode=$("#auto");

            if(wordText!="")
            {
                console.log("cc");
                clearTimeout(timeoutId);

                timeoutId=setTimeout(function () {
                $.post("AutoComplete",{word:wordText},function (data) {
                    console.log("bb");
                    //将DOM对象换成jquery对象
                    var jqueryObj=$(data);
                    var wordNodes=jqueryObj.find("word");

                    autoNode.html("");
                    wordNodes.each(function (i) {
                        var wordNode=$(this);

                        var newDivNode=$("<div>").attr("id",i);
                        newDivNode.html(wordNode.text()).appendTo(autoNode);

                        newDivNode.mouseover(function () {
                            if (highlightindex != -1) {
                                $("#auto").children("div").eq(highlightindex).css("background-color", 'white');
                            }

                            highlightindex = $(this).attr("id");

                            $(this).css("background-color", 'green');
                            console.log("dd");
                        });
                            newDivNode.mouseout(function () {

                                $(this).css("background-color", "white");
                                console.log("ee");
                            });
                                newDivNode.click(function () {
                                    var comTest=$(this).text();
                                    $("#auto").hide();
                                    highlightindex=-1;
                                    $("#word").val(comTest);
                                    console.log("dd");

                                });
                            });

                            if(wordNodes.length>0)
                            {
                                autoNode.show();
                            }else{
                                autoNode.hide();
                                highlightindex=-1;
                            }

                        },"xml");

                    },500);

                }
                else{
                    autoNode.hide();
                    highlightindex=-1;
                console.log("ee");

                }
            autoNode.show();
            }
            else if(keyCode==38||keyCode==40) {
            console.log("ff");

                if (keyCode == 38) {
                    console.log("hh");
                    var autoNodes = $("#auto").children("div");
                    if (highlightindex != -1) {
                        autoNodes.eq(highlightindex).css("backgrounnd-color", "white");
                        highlightindex--;
                    } else {
                        highlightindex = autoNodes.length - 1;
                    }
                    if (highlightindex == -1) {
                        highlightindex = autoNodes.length - 1;
                    }
                    autoNodes.eq(highlightindex).css("background-color", "green");
                }
                if (keyCode == 40) {
                    console.log("ii");
                    var autoNodes = $("#auto").children("div");
                    if (highlightindex != -1) {
                        autoNodes.eq(highlightindex).css("background-color", "white");
                    }
                    highlightindex++;
                    if (highlightindex == autoNodes.length) {
                        highlightindex = 0;
                    }
                    autoNodes.eq(highlightindex).css("background-color", "green");
                }
            } else if (keyCode == 13) {
            console.log("jj");
                if (highlightindex != -1) {
                    var comTest = $("#auto").hide().children("div").eq(highlightindex).text();
                    highlightindex = -1;
                    $("#word").val(comTest);
                } else {

                    $("#auto").hide();
                    $("#word").get(0).blur();
                }
            }

        });






    })

