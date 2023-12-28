<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>${appTitle}</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="/js/axios.min.js"></script>
    <%@ include file="/WEB-INF/view/include/head.jspf"%>
    <c:choose>
    <c:when test="${fn:containsIgnoreCase(ua, 'Trident')}">
<body class="preload hold-transition skin-blue sidebar-mini">
</c:when>
<c:otherwise>
<body class="hold-transition skin-blue sidebar-mini">
</c:otherwise>
</c:choose>
</head>
<body>
<div class="wrapper">
    <!-- nav, sidebar -->
    <%@ include file="/WEB-INF/view/include/nav.jspf"%>
    <div class="content-wrapper">
        <div class="content body">
            <section class="content container-fluid">

                <div name="searchType" style= "display: inline-block">
                    <input type="text"  id="obigo">
                    <input type="number" id="obigo3">
                    <input type="text"  id="obigo2">
                    <br>
                    <input type="number" id="classNo">
                    <input type="text"  id="className">
                    <br>
                    <button type="button" onclick="getTest()">btn</button>
                    <button type="button" id="obigoBtn">obigobtn</button>
                    <button type="button" onclick="postTest()">postbtn</button>
                    <button type="button" onclick="reqBodyTest()">btn3</button>
                </div>
                <br>
            <input type="text" id="resTest"/>
        </div>
    </div>
    <%@ include file="/WEB-INF/view/include/footer.jspf"%>
</div>
</body>
<script>

    document.getElementById("obigoBtn").onclick= function (){
        let obigo = document.getElementById('obigo').value;

        let url= 'obigo2/'+obigo;

        axios.get(url).then(function (response) {
            document.getElementById('resTest').value = response.data;
        }).catch(function (error){
            console.log('doInsert-> error', error)
        })
    }

    function getTest() {
        let obigo = document.getElementById('obigo').value;
        let obigo2 = document.getElementById('obigo2').value;
        let params = new URLSearchParams();

        params.append('obigo', obigo);
        params.append('obigo2', obigo2);

        axios.get('/obigo?'+params).then(function (response) {
            document.getElementById('resTest').value = response.data;
        }).catch(function (error){
            console.log('doInsert-> error', error)
        })

        // console.log(obigo, obigo2);
    }

    function postTest() {
        let obigo= document.getElementById('obigo').value;
        let obigo2= document.getElementById('obigo2').value;

        let params = new URLSearchParams();
        params.append('obigo', obigo);
        params.append('obigo2', obigo2);

        axios.post('/obigo3', params).then(function (response){
            document.getElementById('resTest').value = response.data;

        }).catch(function (error){
            console.log('doInsert-> error', error);
        })

    }

    function reqBodyTest() {
        let name= document.getElementById('obigo').value;
        let age= document.getElementById('obigo3').value;
        let addr= document.getElementById('obigo2').value;
        let classNo = document.getElementById('classNo').value;
        let className = document.getElementById('className').value;

        // let userVo = new Object();
        // let userVo= {};
        //
        // userVo.name = name;
        // userVo.age = age;
        // userVo.addr = addr;
        //
        // userVo.classVo={};
        // userVo.classVo.ClassNo = classNo;
        // userVo.classVo.ClassName = className;

        let userVo = {
            name: name,
            age: age,
            addr: addr,
            classVo: {
                classNo: classNo,
                className: className
            }
        };

        axios.post('/user', userVo).then(function (response){
            document.getElementById('resTest').value = JSON.stringify(response.data);

        }).catch(function (error){
            console.log('doInsert-> error', error);
        })
    }

</script>
</html>
