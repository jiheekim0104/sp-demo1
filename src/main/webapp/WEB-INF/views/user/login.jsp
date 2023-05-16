<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/common/head.jsp" %>
</head>
<body>
<script>
function validate(event, obj){
   if (!obj.checkValidity()) {
      event.preventDefault()
      event.stopPropagation()
   }
   obj.classList.add('was-validated')
}
</script>
   <section class="h-100">
      <div class="container h-100">
         <div class="row justify-content-sm-center h-100">
            <div class="col-xxl-4 col-xl-5 col-lg-5 col-md-7 col-sm-9">
               <div class="text-center my-5">
                  <img src="https://getbootstrap.com/docs/5.0/assets/brand/bootstrap-logo.svg" alt="logo" width="100">
               </div>
               <div class="card shadow-lg">
                  <div class="card-body p-5">
                     <h1 class="fs-4 card-title fw-bold mb-4">Login</h1>
                     <form method="POST" class="needs-validation" action="/login" novalidate="" autocomplete="off" onsubmit="validate(event, this)">
                        <div class="mb-3">
                           <label class="mb-2 text-muted" for="uiId">ID</label>
                           <input id="uiId" type="text" class="form-control" name="uiId" value="" required autofocus>
                           <div class="invalid-feedback">
                              Id is invalid
                           </div>
                        </div>

                        <div class="mb-3">
                           <div class="mb-2 w-100">
                              <label class="text-muted" for="password">Password</label>
                              <a href="forgot.html" class="float-end">
                                 Forgot Password?
                              </a>
                           </div>
                           <input id="uiPwd" type="password" class="form-control" name="uiPwd" required>
                            <div class="invalid-feedback">
                               Password is required
                            </div>
                        </div>

                        <div class="d-flex align-items-center">
                           <div class="form-check">
                              <input type="checkbox" name="remember" id="remember" class="form-check-input">
                              <label for="remember" class="form-check-label">Remember Me</label>
                           </div>
                           <button type="submit" class="btn btn-primary ms-auto">
                              Login
                           </button>
                        </div>
                     </form>
                  </div>
                  <div class="card-footer py-3 border-0">
                     <div class="text-center">
                        Don't have an account? <a href="register.html" class="text-dark">Create One</a>
                     </div>
                  </div>
               </div>
               <div class="text-center mt-5 text-muted">
                  Copyright &copy; 2017-2021 &mdash; Your Company 
               </div>
            </div>
         </div>
      </div>
   </section>
</body>
</html>