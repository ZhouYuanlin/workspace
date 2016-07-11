/**
 * Created by STT_PC on 2016/4/25.
 */
$(function(){
    $(".search_condition li").click(function () {
        $(".search_condition li").removeClass("current");
        $(this).addClass("current");
    });
    $(".page li").click(function () {
        $(".page li").removeClass("page_current");
        $(this).addClass("page_current");
    });
    $(".search_results li").click(function () {
        $(".search_results li").removeClass("current_li");
        $(this).addClass("current_li");
    });
    document.getElementById("search").addEventListener("keyup",function(){
        if(this.value.length>0)
        {
            document.getElementById("cls").onclick=function()
            {
                document.getElementById("search").value="";
            }
        }
    });
});
