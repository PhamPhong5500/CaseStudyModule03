<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
</head>
<body>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>
<div class="container">
    <div class="card w-50 mx-auto my-5">
        <div class="card-header text-center"> UserLogin</div>
        <div class="card-body">
            <form action="/list" method="post">
                <div class="form-group">
                    <label>Email Address</label>
                    <input type="email" class="form-control" name="Login Email" placeholder="Enter your Email">
                </div>
                <div class="form-group">
                    <label>Password</label>
                    <input type="password" class="form-control" name="Login Password" placeholder="********" required>
                </div>

                <div class="text-center">
                    <button type="submit" class="btn btn-primary">Login</button>
                </div>
            </form>
        </div>
    </div>
</div>
<%--<div class="container">--%>
<%--    <div class="card w-50 mx-auto my-5">--%>
<%--        <div class="card-header text-center">User Login</div>--%>
<%--        <div class="card-body">--%>
<%--            <form action="user-login" method="post">--%>
<%--                <div class="form-group">--%>
<%--                    <label>Email address</label><br>--%>
<%--                    <input type="email" name="login-email" class="form-control" placeholder="Enter email"> <br>--%>
<%--                </div>--%>
<%--                <div class="form-group">--%>
<%--                    <label>Password</label><br>--%>
<%--                    <input type="password" name="login-password" class="form-control" placeholder="Password"> <br> <br>--%>
<%--                </div>--%>
<%--                <div class="text-center">--%>
<%--                    <button type="submit" class="btn btn-primary">Login</button>--%>
<%--                </div>--%>
<%--            </form>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>

</body>
</html>