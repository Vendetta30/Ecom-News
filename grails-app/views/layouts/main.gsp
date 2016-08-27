<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title><g:layoutTitle/></title>
    <link href='https://fonts.googleapis.com/css?family=Signika+Negative:400,300,600,700' rel='stylesheet'
          type='text/css'>
    <link href='https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css' rel='stylesheet'
          type='text/css'>
    <link rel="shortcut icon" href="${assetPath(src: 'favicon.ico')}">
    <asset:stylesheet src="application.css"/>
    <asset:javascript src="application.js"/>
    <g:layoutHead/>

</head><!--/head-->
<body class="box-layout">
<div id="main-wrapper" class="box-width">
    <header id="navigation">
        <div class="navbar" role="banner">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>

                    <a class="navbar-brand" href="index.html">
                        <asset:image class="main-logo img-responsive" src="logo.png" alt=""/>
                    </a>
                </div>
                <g:render template="/template/navigation"/>

                <div class="searchNlogin">
                    <ul>
                        <li class="search-icon"><i class="fa fa-search"></i></li>
                        <li class="dropdown user-panel"><a href="javascript:void(0);" class="dropdown-toggle"
                                                           data-toggle="dropdown"><i class="fa fa-user"></i></a>

                            <div class="dropdown-menu top-user-section">
                                <div class="top-user-form">
                                    <form action="${request.contextPath}/j_spring_security_check" method='POST'
                                          id='loginForm' class='cssform' autocomplete='off'>
                                        <div class="input-group" id="top-login-username">
                                            <span class="input-group-addon">
                                                <asset:image src="others/user-icon.png"
                                                             alt=""/>
                                            </span>
                                            <input type='text' class='form-control' name='j_username' id='username'/>
                                        </div>

                                        <div class="input-group" id="top-login-password">
                                            <span class="input-group-addon">
                                                <asset:image src="others/password-icon.png"
                                                             alt=""/>
                                            </span>
                                            <input type='password' class='form-control' name='j_password'
                                                   id='password'/>
                                        </div>

                                        <div>
                                            <p class="reset-user">Forgot <a href="#">Password/Username?</a></p>
                                            <input type='submit' id="submit"
                                                   value='${message(code: "springSecurity.login.button")}'
                                                   class="btn btn-danger"/>
                                        </div>
                                    </form>
                                </div>

                                <div class="create-account">
                                    <a href="#">Create a New Account</a>
                                </div>
                            </div>
                        </li>
                    </ul>

                    <div class="search">
                        <form>
                            <input type="text" class="search-form" autocomplete="off" placeholder="Type & Press Enter">
                        </form>
                    </div> <!--/.search-->
                </div><!--.searchNlogin -->
            </div>
        </div>
    </header><!--/#navigation-->

<g:layoutBody/>

    <div class="footer-top">
        <div class="container-fluid">
            <ul class="list-inline social-icons text-center">
                <li><a href="#"><i class="fa fa-facebook"></i>Facebook</a></li>
                <li><a href="#"><i class="fa fa-twitter"></i>Twitter</a></li>
                <li><a href="#"><i class="fa fa-google-plus"></i>Google Plus</a></li>
                <li><a href="#"><i class="fa fa-linkedin"></i>Linkedin</a></li>
                <li><a href="#"><i class="fa fa-pinterest"></i>Pinterest</a></li>
                <li><a href="#"><i class="fa fa-youtube"></i>Youtube</a></li>
            </ul>
        </div>
    </div><!--/.footer-top-->

    <footer id="footer">
        <div class="bottom-widgets">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-sm-4">
                        <div class="widget">
                            <h2>Categories</h2>
                            <ul>
                                <li><a href="#">Business</a></li>
                                <li><a href="#">Politics</a></li>
                                <li><a href="#">Sports</a></li>
                                <li><a href="#">World</a></li>
                                <li><a href="#">Technology</a></li>
                            </ul>
                            <ul>
                                <li><a href="#">Environment</a></li>
                                <li><a href="#">Health</a></li>
                                <li><a href="#">Entertainment</a></li>
                                <li><a href="#">Lifestyle</a></li>
                            </ul>
                        </div>
                    </div>

                    <div class="col-sm-2">
                        <div class="widget">
                            <h2>Editions</h2>
                            <ul>
                                <li><a href="#">United States</a></li>
                                <li><a href="#">China</a></li>
                                <li><a href="#">India</a></li>
                                <li><a href="#">Maxico</a></li>
                                <li><a href="#">Middle East</a></li>
                            </ul>
                        </div>
                    </div>

                    <div class="col-sm-4">
                        <div class="widget">
                            <h2>Popular Tags</h2>
                            <ul>
                                <li><a href="#">Gallery</a></li>
                                <li><a href="#">Sports</a></li>
                                <li><a href="#">Featured</a></li>
                                <li><a href="#">World</a></li>
                                <li><a href="#">Fashion</a></li>
                            </ul>
                            <ul>
                                <li><a href="#">Environment</a></li>
                                <li><a href="#">Health</a></li>
                                <li><a href="#">Entertainment</a></li>
                                <li><a href="#">Lifestyle</a></li>
                                <li><a href="#">Business</a></li>
                            </ul>
                            <ul>
                                <li><a href="#">Tech</a></li>
                                <li><a href="#">Movie</a></li>
                                <li><a href="#">Music</a></li>
                            </ul>
                        </div>
                    </div>

                    <div class="col-sm-2">
                        <div class="widget">
                            <h2>Products</h2>
                            <ul>
                                <li><a href="#">Ebook</a></li>
                                <li><a href="#">Baby Product</a></li>
                                <li><a href="#">Magazine</a></li>
                                <li><a href="#">Sports Elements</a></li>
                                <li><a href="#">Technology</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="footer-bottom">
            <div class="container-fluid text-center">
                <p>Copyright &copy; 2016,  DailyNews. Developed by <a href="#">Nexthoughts</a></p>
            </div>
        </div>
    </footer>
</div><!--/#main-wrapper-->
<script>
    (function (i, s, o, g, r, a, m) {
        i['GoogleAnalyticsObject'] = r;
        i[r] = i[r] || function () {
                    (i[r].q = i[r].q || []).push(arguments)
                }, i[r].l = 1 * new Date();
        a = s.createElement(o),
                m = s.getElementsByTagName(o)[0];
        a.async = 1;
        a.src = g;
        m.parentNode.insertBefore(a, m)
    })(window, document, 'script', '//www.google-analytics.com/analytics.js', 'ga');

    ga('create', 'UA-73239902-1', 'auto');
    ga('send', 'pageview');

</script>
</body>
</html>