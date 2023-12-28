<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${appTitle}</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="/js/axios.min.js"></script>
    <%@ include file="/WEB-INF/view/include/head.jspf"%>

    <body class="preload hold-transition skin-blue sidebar-mini">

</head>
<body>
    <div class="wrapper">
        <%@ include file="/WEB-INF/view/include/nav.jspf"%>
            <div class="content-wrapper">
                <div class="content-body">
                    <section class="content container-fluid">

                        <div name="searchType" style= "display: inline-block">

                            name: <input type="text" value="nameKey" placeholder="">

                            email: <input type="text" value="emailKey" placeholder="">

                            address: <input type="text" value="addressKey" placeholder="">

                            <button type="button" onclick="" id="searchBtn">SEARCH</button>
                        </div>

                        <div class="box box-solid">
                            <div class="box-header with-border">
                                <h3 class="box-title" style="font-weight: bold;">Company</h3>
                            </div>
                            <div class="box-body">
                                <div class="row">
                                    <div class="col-md-12">
                                        <table class="table table-condensed table-hover" id="table-company">
                                            <thead>
                                                <tr>
                                                    <th>ID</th>
                                                    <th>NAME</th>
                                                    <th>EMAIL</th>
                                                    <th>ADDRESS</th>
                                                    <th>DESCRIPTION</th>
                                                </tr>
                                            </thead>
                                            <tbody id="table-list-body"></tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                            <button id="deleteBtn"> 삭제 </button>
                        </div>
                    </section>
                </div>
            </div>
            <%@ include file="/WEB-INF/view/include/footer.jspf"%>
        </div>
</body>

<script>

    const setCompanyTable = function (data) {
        document.getElementById('table-list-body').innerHTML='';
        // 테이블에서 셀들로 이루어진 하나의 행(row)을 정의
        let tr = '';
        for ( let i = 0; i < data.length ;  i++ ){
            let td='';
            td += "<td>" + data[i].companySeq + "</td>";
            td += "<td>" + data[i].name + "</td>";
            td += "<td>" + data[i].email + "</td>";
            td += "<td>" + data[i].address + "</td>";
            td += "<td>" + data[i].description+ "</td>";

            tr += "<tr>" + td + "</tr>";
        }
        document.getElementById('table-list-body').innerHTML = tr;
    }

    const selectCompanyList = function() {
        axios.get('/company', null).then(function (response) {
            console.log('response.data: ', response.data);
            setCompanyTable(response.data);
        }).catch(function (error) {
            console.log('doLogin()->error=', error);
        });
    };

    function insertCompany(){
        axios.put('/company').then(function (response) {
            setCompanyTable(response.data)
                }
        ).catch(function(error){
            console.log('doInsert -> error', error);
        });
    };

    let checkedCompany = 1;

    document.getElementById('deleteBtn').onclick = function deleteCompany() {
        let result = alert('삭제?');
        if (result){
            axios.delete('/company/${checkedCompany}')

              .then(function(response){
                console.log(response);
            }).catch(function(error){
                console.log(error);
            });
        }
    };

    window.addEventListener('DOMContentLoaded', function (){
        console.log('DOMContentLoaded() called...');

        selectCompanyList();

    }, false);

</script>
</html>
