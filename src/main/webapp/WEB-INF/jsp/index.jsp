<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/res/js/jquery-3.4.1.min.js"></script>
</head>
<body>
<p>
    关键词<input type="text" id="keyWord"/>
    <input type="button" value="查询" onclick="seach()"/>
</p>
<p>
    <h1>热点事件排行榜</h1>
</p>
<table id="infoTable">
    <tr id="titleTr">
        <td>关键词</td>
        <td>搜索指数</td>
        <td>创建时间</td>
    </tr>
</table>
<p>
    <a href="javascript:fristPage()">首页</a>
    <a href="javascript:lastPage()">上一页</a>
    <a href="javascript:nextPage()">下一页</a>
    <a href="javascript:lastPage()">尾页</a>
    第<span id="pageNo">1</span>页/共<span id="pageCount">？</span>页

</p>
<script type="text/javascript">
    $(function () {
        init();
    });
    function init() {
        $("#titleTr~tr").remove();

        var url="${pageContext.request.contextPath}/hotevents/list";
        var pageIndex=$("#pageNo").html();
        var keyWord=$("#keyWord").val();
        url+="?pageIndex="+pageIndex;
        if(keyWord!=null&&keyWord!=''){
            url+="&keyWord="+keyWord;
        }
        $.ajax({
            url:url,
            type:"get",
            dataType:"json",
            success:function (data) {
                $("#pageNo").html(data.page.currentPageNo);
                $("#pageCount").html(data.page.totalPageCount);

                $("#keyWord").val(data.keyWord);
                for(var i in data.hoteventsList){
                   var result="<tr>";
                    result+="<td>"+data.hoteventsList[i].keyWord+"</td>";
                    result+="<td>"+data.hoteventsList[i].searchSum+"</td>";
                    result+="<td>"+data.hoteventsList[i].createDate+"</td>";
                    result+="</tr>";
                    $("#titleTr").after(result);
                }
            }
        })
    }
    function fristPage() {
        $("#pageNo").html(1);
        init();
    }
    function lastPage() {
        $("#pageNo").html($("#pageCount").html());
        init();
    }
    function nextPage() {
        var pageNo= parseInt($("#pageNo").html())+1;
        if(pageNo>$("#pageCount").html()){
            pageNo=$("#pageCount").html();
        }
        $("#pageNo").html(pageNo);
        init();
    }
    function lastPage() {
        var pageNo= parseInt($("#pageNo").html())-1;
        if(pageNo<1){
            pageNo=1;
        }
        $("#pageNo").html(pageNo);
        init();
    }
    function seach() {
        init();
    }
</script>
</body>
</html>