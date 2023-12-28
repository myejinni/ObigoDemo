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
    <link rel="stylesheet" href="/dist/css/skins/skin-obigo-tms-simulator.css">
    <link rel="stylesheet" href="/dist/css/AdminLTE-obigo-tms.css">
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
<style>
    #table-list-body {
        cursor: pointer;
    }
</style>

<body>
<div class="wrapper">
    <!-- nav, sidebar -->
    <%@ include file="/WEB-INF/view/include/nav.jspf"%>
    <div class="content-wrapper">
        <div class="content body">
            <section class="content container-fluid">
                <div class="box box-solid">
                    <div class="box-header with-border">
                        <h3 class="box-title" style="font-weight: bold;">User</h3>
                    </div>
                    <div class="box-body">
                        <div class="row">
                            <div class="col-md-12">
                                <table class="table table-condensed table-hover" id="table-company">
                                    <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Name</th>
                                        <th>Age</th>
                                        <th>Address</th>
                                    </tr>
                                    </thead>
                                    <tbody id="table-list-body">
                                    <%-- "users"라는 이름으로 추가된 데이터에 접근 --%>
                                    <c:forEach items="${users}" var="user">
                                        <tr onclick="userDetail(${user.userId})">
                                            <td>${user.userId}</td>
                                            <td>${user.name}</td>
                                            <td>${user.age}</td>
                                            <td>${user.addr}</td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>

                                </table>
                            </div>
                        </div>
                    </div>
                    <%--  paging number  --%>
                    <div class="box-footer clearfix">
                        <div class="text-center">
                            <ul class="pagination">
                                <c:if test="${pageMake.prev}">
                                    <li><a href="${path}/user/userPage?page=${pageMake.startPage - 1}">이전</a></li>
                                </c:if>

                                <c:forEach begin="${pageMake.startPage}" end="${pageMake.endPage}" var="idx">
                                    <li <c:if test="${pageMake.pageVO.page == idx}">class="active"</c:if>>
                                        <a href="${path}/user/userPage?page=${idx}">${idx}</a>
                                    </li>
                                </c:forEach>

                                <c:if test="${pageMake.next && pageMake.endPage > 0}">
                                    <li><a href="${path}/user/userPage?page=${pageMake.endPage + 1}">다음</a></li>
                                </c:if>
                            </ul>
                        </div>

                        <div class="box-tools pull-right">
                            <button id="btnAdd" class="btn btn-obigo btn-sm" onclick="btnHide()">Add</button>
                        </div>
                    </div>

                </div>

                <!-- Modal Pop : LogDetail -->
                <div class="modal fade" id="modal" tabindex="-1" role="dialog" aria-labelledby="pfModalLabel" aria-hidden="true" data-toggle="modal">
                    <div class="modal-dialog">
                        <div class="custom-content">
                            <div class="custom-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <div class="close-icon"></div>
                                </button>
                                <div class="custom-title">유저 상세</div>
                                <input id="m_userId" type="hidden"/>
                            </div>
                            <div class="custom-body">
                                <div class="custom-group">
                                    <div class="custom-label">이름</div>
                                    <input class="custom-input" id ="m_name"/>
                                </div>
                            </div>
                            <div class="custom-body">
                                <div class="custom-group">
                                    <div class="custom-label">나이</div>
                                    <input class="custom-input" id ="m_age"/>
                                </div>
                            </div>
                            <div class="custom-body">
                                <div class="custom-group">
                                    <div class="custom-label">주소</div>
                                    <input class="custom-input" id ="m_addr"/>
                                </div>
                            </div>

                            <div class="modal-footer">
                                <button type="button" id="btnModalSave" class="btn btn-obigo" onclick="insertAndUpdate()">Save</button>
                                <button type="button" id="btnModalDelete" class="btn btn-danger">Delete</button>
                                <button type="button" id="btnModalCancel" class="btn btn-default" data-dismiss="modal">Cancel</button>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.Modal Pop : LogDetail -->
            </section>
        </div>
    </div>
    <%@ include file="/WEB-INF/view/include/footer.jspf"%>
</div>
</body>
<script>

    window.addEventListener('DOMContentLoaded', function() {
        console.log('DOMContentLoaded() called...');
        selectUserList();
    }, false);

    const selectUserList = function() {
        axios.post( '/user', null ).then( function (response) {
            console.log( 'response.data : ', response.data );
            // setUserTable(response.data);

        }).catch( function (error) {
            console.log('doLogin() -> error=', error);
        });
    };

    function insertUser() {
        let name = getID('m_name').value;
        let age = getID('m_age').value;
        let address = getID('m_addr').value;

        let userVO = {
            name: name,
            addr: address,
            age: age
        };

        axios.post('/user/insert', userVO).then(function (response) {
            selectUserList();
            initModal();
            $('#modal').modal('hide');

        }).catch(function (error) {
            console.log('doLogin() -> error=', error);
        });
    }

    const updateUser = function() {
        const userVo = {
            'userId': getID('m_userId').value,
            'name': getID('m_name').value,
            'addr': getID('m_addr').value,
            'age': getID('m_age').value
        }

        axios.post('/user/update', userVo).then(function (response) {
            selectUserList();
            initModal();
            $('#modal').modal('hide');

        }).catch(function (error) {
            console.log('doLogin() -> error=', error);
        });
    }

    const insertAndUpdate = function() {
        if(getID('m_userId').value === '' ) {
            insertUser();
        }
        else {
            updateUser();
        }
    }

    const initModal = function() {
        getID('m_name').value = '';
        getID('m_age').value = '';
        getID('m_addr').value = '';
        getID('m_userId').value = '';
    }

    const userDetail = function(userId) {

        console.log('선택된 아이디 : ', userId);
        let url = '/user/' + userId;

        axios.get(url).then( function (response) {
            const user = response.data;
            console.log(user);

            getID('m_name').value = user.name;
            getID('m_age').value = user.age;
            getID('m_addr').value = user.addr;
            getID('m_userId').value = user.userId;

        }).catch( function (error) {
            console.log('doLogin() -> error=', error);
        });

        if(getID('btnModalDelete').style.display === 'none'){
            getID('btnModalDelete').style.display = 'show'
        }

        $("#modal").modal({
            closeExisting: false
        });
    }

    const deleteButton = document.getElementById('btnModalDelete');

    deleteButton.addEventListener('click', function () {
        let id = getID('m_userId').value;
        let result = confirm('삭제하시겠습니까?');
        console.log(id);

        if (result) {
            let url = '/user/' + id;
            axios.delete(url).then(function (response) {
                selectUserList();
                $('#modal').modal('hide');
                console.log(response.data);
            }).catch(function (error) {
                console.log(error);
            });
        }
    })


    // const setUserTable = function(data) {
    //     document.getElementById('table-list-body').innerHTML = '';
    //     let tr = '';
    //     for ( let i = 0 ; i < data.length ; i++ ) {
    //         let td = '';
    //         td += "<td>" + data[i].userId + "</td>";
    //         td += "<td>" + data[i].name + "</td>";
    //         td += "<td>" + data[i].age + "</td>";
    //         td += "<td>" + data[i].addr + "</td>";
    //         tr += "<tr id='tr' onclick='userDetail("+data[i].userId+")'>" + td + "</tr>";
    //     }
    //     document.getElementById('table-list-body').innerHTML = tr;
    // }

    const getID = function(id) {
        const ele = document.getElementById(id);
        return ele;
    }

    const btnHide = function() {
        if(getID('btnModalDelete').style.display !== 'none'){
            console.log("클릭")
            getID('btnModalDelete').style.display = "none";
        } else
            getID('btnModalDelete').style.display = "block";

    }

    if(getID('btnAdd')!=null) {
        getID('btnAdd').onclick = function(e) {
            initModal();
            $("#modal").modal({
                closeExisting: false
            });
        }
    }

    // const userPaging = function(page) {
    //
    //     console.log('page : ', page);
    //     let url = '/user/' + page;
    //
    //     axios.get(url).then( function (response) {
    //         const user = response.data;
    //         console.log(user);
    //
    //         selectUserList();
    //
    //     }).catch( function (error) {
    //         console.log('doLogin() -> error=', error);
    //     });
    //
    // }

    const userPaging = function(page) {
        console.log('page : ', page);
        let url = '/user/userPage?page=' + page; // 페이지 번호를 URL에 추가

        axios.get(url).then( function (response) {
            const users = response.data;
            console.log(users);

            // 사용자 목록 업데이트
            // setUserTable(users);

        }).catch( function (error) {
            console.log('userPaging() -> error=', error);
        });
    };

</script>
</html>