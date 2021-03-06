<%@ page import="java.sql.Date" %><%--
  Created by IntelliJ IDEA.
  User: yejianwen
  Date: 2019/3/18
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="no-js" lang=""> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>jwxt home</title>
    <meta name="description" content="Ela Admin - HTML5 Admin Template">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="apple-touch-icon" href="https://i.imgur.com/QRAUqs9.png">
    <link rel="shortcut icon" href="https://i.imgur.com/QRAUqs9.png">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/normalize.css@8.0.0/normalize.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/font-awesome@4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/lykmapipo/themify-icons@0.1.2/css/themify-icons.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/pixeden-stroke-7-icon@1.2.3/pe-icon-7-stroke/dist/pe-icon-7-stroke.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/flag-icon-css/3.2.0/css/flag-icon.min.css">
    <link rel="stylesheet" href="assets/css/cs-skin-elastic.css">
    <link rel="stylesheet" href="assets/css/lib/datatable/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/style.css">
    <!-- <script type="text/javascript" src="https://cdn.jsdelivr.net/html5shiv/3.7.3/html5shiv.min.js"></script> -->
    <link href="https://cdn.jsdelivr.net/npm/chartist@0.11.0/dist/chartist.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/jqvmap@1.5.1/dist/jqvmap.min.css" rel="stylesheet">

    <link href="https://cdn.jsdelivr.net/npm/weathericons@2.1.0/css/weather-icons.css" rel="stylesheet" />
    <link href="https://cdn.jsdelivr.net/npm/fullcalendar@3.9.0/dist/fullcalendar.min.css" rel="stylesheet" />

    <script src="https://cdn.jsdelivr.net/npm/js-cookie@2/src/js.cookie.min.js"></script>

    <script type="text/javascript" src="assets/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="assets/js/sideBarCookieCache.js"></script>



    <style>
        #weatherWidget .currentDesc {
            color: #ffffff!important;
        }
        .traffic-chart {
            min-height: 335px;
        }
        #flotPie1  {
            height: 150px;
        }
        #flotPie1 td {
            padding:3px;
        }
        #flotPie1 table {
            top: 20px!important;
            right: -10px!important;
        }
        .chart-container {
            display: table;
            min-width: 270px ;
            text-align: left;
            padding-top: 10px;
            padding-bottom: 10px;
        }
        #flotLine5  {
            height: 105px;
        }

        #flotBarChart {
            height: 150px;
        }
        #cellPaiChart{
            height: 160px;
        }

    </style>
</head>

<body>
<!-- Left Panel -->
<aside id="left-panel" class="left-panel">
    <nav class="navbar navbar-expand-sm navbar-default">
        <div id="main-menu" class="main-menu collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active">
                    <a href="/home"><i class="menu-icon fa fa-laptop"></i>主页</a>
                </li>
                <li class="menu-title" id="debug"></li><!-- /.menu-title -->
                <li class="menu-title">业务中心</li><!-- /.menu-title -->
                <li class="menu-item-has-children dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-cogs"></i>院系信息</a>
                    <ul class="sub-menu children dropdown-menu">
                        <li><i class="fa"></i><a href="/home">学院</a></li>
                        <li><i class="fa"></i><a href="/major">专业</a></li>
                        <li><i class="fa"></i><a href="/org">机构</a></li>
                    </ul>
                </li>

                <li class="menu-title admin" style="display: none">管理员</li><!-- /.menu-title -->
                <li class="dropdown admin" style="display: none">
                    <a href="#"> <i class="menu-icon fa fa-table"></i>学院管理</a>
                </li>
                <li class="dropdown admin" style="display: none">
                    <a href="#"> <i class="menu-icon fa fa-table"></i>机构管理</a>
                </li>
                <li class="dropdown admin" style="display: none">
                    <a href="#"> <i class="menu-icon fa fa-table"></i>专业管理</a>
                </li>
                <li class="dropdown admin" style="display: none">
                    <a href="#"> <i class="menu-icon fa fa-table"></i>教务员管理</a>
                </li>
                <li class="dropdown admin" style="display: none">
                    <a href="#"> <i class="menu-icon fa fa-table"></i>教师管理</a>
                </li>
                <li class="dropdown admin" style="display: none">
                    <a href="#"> <i class="menu-icon fa fa-table"></i>学生管理</a>
                </li>

                <li class="menu-title officer" style="display: none">教务员</li><!-- /.menu-title -->
                <li class="dropdown officer" style="display: none">
                    <a href="#"> <i class="menu-icon fa fa-table"></i>教务通知</a>
                </li>
                <li class="dropdown officer" style="display: none">
                    <a href="#"> <i class="menu-icon fa fa-table"></i>开课审核</a>
                </li>
                <li class="dropdown officer" style="display: none">
                    <a href="#"> <i class="menu-icon fa fa-table"></i>选课审核</a>
                </li>
                <li class="dropdown officer" style="display: none">
                    <a href="#"> <i class="menu-icon fa fa-table"></i>结课审核</a>
                </li>
                <li class="dropdown officer" style="display: none">
                    <a href="#"> <i class="menu-icon fa fa-table"></i>个人奖惩信息</a>
                </li>
                <li class="dropdown officer" style="display: none">
                    <a href="#"> <i class="menu-icon fa fa-table"></i>教职工信息</a>
                </li>
                <li class="dropdown officer" style="display: none">
                    <a href="#"> <i class="menu-icon fa fa-table"></i>课程讨论</a>
                </li>

                <li class="menu-title teacher" style="display: none">教师</li><!-- /.menu-title -->
                <li class="dropdown teacher" style="display: none">
                    <a href="#"> <i class="menu-icon fa fa-table"></i>开课申请</a>
                </li>
                <li class="dropdown teacher" style="display: none">
                    <a href="#"> <i class="menu-icon fa fa-table"></i>作业发布</a>
                </li>
                <li class="dropdown teacher" style="display: none">
                    <a href="#"> <i class="menu-icon fa fa-table"></i>成绩评定</a>
                </li>
                <li class="dropdown teacher" style="display: none">
                    <a href="#"> <i class="menu-icon fa fa-table"></i>结课申请</a>
                </li>

                <li class="menu-title teacher-assist" style="display: none">助教</li><!-- /.menu-title -->
                <li class="dropdown teacher-assist" style="display: none">
                    <a href="#"> <i class="menu-icon fa fa-table"></i>作业发布</a>
                </li>
                <li class="dropdown teacher-assist" style="display: none">
                    <a href="#"> <i class="menu-icon fa fa-table"></i>成绩评定</a>
                </li>

                <li class="menu-title student" style="display: none">学生</li><!-- /.menu-title -->
                <li class="dropdown student" style="display: none">
                    <a href="#"> <i class="menu-icon fa fa-table"></i>学习讨论</a>
                </li>
                <li class="dropdown student" style="display: none">
                    <a href="#"> <i class="menu-icon fa fa-table"></i>成绩</a>
                </li>
                <li class="dropdown student" style="display: none">
                    <a href="#"> <i class="menu-icon fa fa-table"></i>选课</a>
                </li>
                <li class="dropdown student" style="display: none">
                    <a href="#"> <i class="menu-icon fa fa-table"></i>评教</a>
                </li>

                <li class="dropdown student">
                    <a id="clearCookies" href="#"> <i class="menu-icon fa fa-table"></i>清空缓存</a>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </nav>
</aside>
<!-- /#left-panel -->
<!-- Right Panel -->
<div id="right-panel" class="right-panel">
    <!-- Header-->
    <header id="header" class="header">
        <div class="top-left">
            <div class="navbar-header">
                <a class="navbar-brand" href="/home"><img src="images/jwxt.png" alt="Logo"></a>
                <a id="menuToggle" class="menutoggle"><i class="fa fa-bars"></i></a>
            </div>
        </div>
        <div class="top-right">
            <div class="header-menu">
                <div class="header-left">
                    <button class="search-trigger"><i class="fa fa-search"></i></button>
                    <div class="form-inline">
                        <form class="search-form">
                            <input class="form-control mr-sm-2" type="text" placeholder="搜索 ..." aria-label="Search">
                            <button class="search-close" type="submit"><i class="fa fa-close"></i></button>
                        </form>
                    </div>

                    <div class="dropdown for-notification">
                        <button class="btn btn-secondary dropdown-toggle" type="button" id="notification" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fa fa-bell"></i>
                            <span class="count bg-danger">0</span>
                        </button>
                    </div>

                    <div class="dropdown for-message">
                        <button class="btn btn-secondary dropdown-toggle" type="button" id="message" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fa fa-envelope"></i>
                            <span class="count bg-primary">0</span>
                        </button>
                    </div>
                </div>

                <div class="user-area dropdown float-right">
                    <a href="#" class="dropdown-toggle active" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <img id="headImg" class="user-avatar rounded-circle">
                    </a>

                    <div class="user-menu dropdown-menu">
                        <a id="personalPage" class="nav-link" href="/personalPage" style="display: none"><i class="fa fa- user"></i>个人中心</a>
                        <a id="login" class="nav-link" href="/login"><i class="fa -off"></i>登陆</a>
                        <a id="logout" class="nav-link" href="/logout" style="display: none"><i class="fa -off"></i>退出</a>
                    </div>
                </div>

            </div>
        </div>
    </header>
    <!-- /#header -->
    <!-- Content -->
    <div class="content">
        <!-- Animated -->
        <div class="animated fadeIn">
            <!-- Widgets  -->
            <div id="main-content-box" class="row">
                <div class="col-md-8">
                    <div class="card">
                        <div class="card-header">
                            <strong class="card-title">文件中心</strong>
                        </div>
                        <div class="card-body">
                            <br>
                            <%--<p id="state-message" class="text-center" style="display: none">文件：xxx已删除！</p>--%>
                            <table id="bootstrap-data-table" class="table table-striped table-bordered table-hover" style="word-break:break-all; word-wrap:break-all;">
                                <thead>
                                <tr>
                                    <th>文件名</th>
                                    <th>文件大小</th>
                                    <th>上传日期</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody id="doc-items">
                                <!-- <tr>
                                    <td style="width: 30em; word-break:break-all; word-wrap:break-all;"></td>
                                    <td></td>
                                    <td></td>
                                    <td>
                                        <button type="button" class="btn btn-danger btn-sm"><a style="color: black" href="">删除</a></button>
                                        <button type="button" class="btn btn-primary btn-sm"><a style="color: black" href="">重命名</a></button>
                                        <button type="button" class="btn btn-success btn-sm"><a style="color: black" href="">下载</a></button>
                                    </td>
                                </tr> -->
                                    <%
                                        String[] docNames = (String[]) request.getAttribute("docNames");
                                        int[] docIds = (int[]) request.getAttribute("docIds");
                                        Date[] publishDates = (Date[]) request.getAttribute("publishDates");
                                        int[] docSizes = (int[]) request.getAttribute("docSizes");
                                        for (int i = 0; i < docNames.length; i++) {
                                        	String txt = "<tr><td style=\"width: 30em; word-break:break-all; word-wrap:break-all;\">";
                                            txt += docNames[i];
                                            txt += "</td><td>";
                                            txt += docSizes[i];
                                            txt += "</td><td>";
                                            txt += publishDates[i];
                                            txt += "</td><td><button type=\"button\" class=\"btn btn-danger btn-sm\"><a style=\"color: black\" href=\"";
                                            txt += "/deleteUploadFiles?docId=" + docIds[i];
                                            txt += "\">删除</a></button><button type=\"button\" class=\"btn btn-success btn-sm\"><a style=\"color: black\" href=\"";
                                            txt += "/downloadUploadFiles?docId=" + docIds[i];
                                            txt += "\">下载</a></button></td></tr>";
                                            out.print(txt);
                                        }
                                    %>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <!-- /Widgets -->
            <!-- Calender -->
            <div class="row">
                <div class="col-md-12 col-lg-4">
                    <div class="card">
                        <div class="card-body">
                            <!-- <h4 class="box-title">Chandler</h4> -->
                            <div class="calender-cont widget-calender">
                                <div id="calendar"></div>
                            </div>
                        </div>
                    </div><!-- /.card -->
                </div>
            </div>
            <!-- /Calender Chart Weather -->
        </div>
        <!-- .animated -->
    </div>
    <!-- /.content -->
    <div class="clearfix"></div>
    <!-- Footer -->
    <footer class="site-footer">
        <div class="footer-inner bg-white">
            <div class="row">
                <div class="col-sm-6">
                    Copyright &copy; 2019 SYSU JWXT
                </div>
                <div class="col-sm-6 text-right">
                    Designed by Lifam
                </div>
            </div>
        </div>
    </footer>
    <!-- /.site-footer -->
</div>
<!-- /#right-panel -->

<!-- Scripts -->
<script src="https://cdn.jsdelivr.net/npm/jquery@2.2.4/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.4/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery-match-height@0.7.2/dist/jquery.matchHeight.min.js"></script>
<script src="assets/js/main.js"></script>

<!--  Chart js -->
<script src="https://cdn.jsdelivr.net/npm/chart.js@2.7.3/dist/Chart.bundle.min.js"></script>

<!--Chartist Chart-->
<script src="https://cdn.jsdelivr.net/npm/chartist@0.11.0/dist/chartist.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chartist-plugin-legend@0.6.2/chartist-plugin-legend.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/jquery.flot@0.8.3/jquery.flot.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/flot-pie@1.0.0/src/jquery.flot.pie.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/flot-spline@0.0.1/js/jquery.flot.spline.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/simpleweather@3.1.0/jquery.simpleWeather.min.js"></script>
<script src="assets/js/init/weather-init.js"></script>

<script src="https://cdn.jsdelivr.net/npm/moment@2.22.2/moment.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/fullcalendar@3.9.0/dist/fullcalendar.min.js"></script>
<script src="assets/js/init/fullcalendar-init.js"></script>

<script src="assets/js/lib/data-table/datatables.min.js"></script>
<script src="assets/js/lib/data-table/dataTables.bootstrap.min.js"></script>
<script src="assets/js/lib/data-table/dataTables.buttons.min.js"></script>
<script src="assets/js/lib/data-table/buttons.bootstrap.min.js"></script>
<script src="assets/js/lib/data-table/jszip.min.js"></script>
<script src="assets/js/lib/data-table/vfs_fonts.js"></script>
<script src="assets/js/lib/data-table/buttons.html5.min.js"></script>
<script src="assets/js/lib/data-table/buttons.print.min.js"></script>
<script src="assets/js/lib/data-table/buttons.colVis.min.js"></script>
<script src="assets/js/init/datatables-init.js"></script>
</body>

</html>

