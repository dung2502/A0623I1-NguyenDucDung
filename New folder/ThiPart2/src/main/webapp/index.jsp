<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Title</title>
  <link rel="stylesheet" href="../static/bootstrap-5.0.2-dist/css/bootstrap.css">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css">
  <link rel="stylesheet" href="static/css/home.css">
</head>
<body>
<div class="container-fluid">
  <div class="header">
    <div class="logo">
      <img src="../static/images/logo.png" alt="logo" class="logo">
    </div>
    <div class="login d-flex">
      <a href="#">
        <i class="fa-solid fa-right-to-bracket"> login</i>
      </a>
    </div>
  </div>
  <div class="navbar navbar-expand-lg bg-light">
    <ul class="navbar-nav me-auto">
      <li class="nav-item">
        <a class="nav-link" href="#">Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/elementManager">Product Manager</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/elementManager">2</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/elementManager">3</a>
      </li>
    </ul>
    <div class="searchbar d-flex">
      <div class="searchbar-wrapper">
        <div class="searchbar-left">
          <div class="search-icon-wrapper">
            <span class="search-icon searchbar-icon">
              <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                <path d="M15.5 14h-.79l-.28-.27A6.471 6.471 0 0 0 16 9.5 6.5 6.5 0 1 0 9.5 16c1.61 0
                  3.09-.59 4.23-1.57l.27.28v.79l5 4.99L20.49 19l-4.99-5zm-6 0C7.01 14 5 11.99 5 9.5S7.01
                  5 9.5 5 14 7.01 14 9.5 11.99 14 9.5 14z">
                </path>
              </svg>
            </span>
          </div>
        </div>
        <div class="searchbar-center">
          <div class="searchbar-input-spacer"></div>
          <input type="text" class="searchbar-input" name="q" placeholder="Search">
        </div>
      </div>
    </div>
  </div>
  <div class="main">
    <div class="float-left">
      <ul class="side-bar">
        <li class="nav-item">
          <a class="nav-link" href="#">Item One</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Item Two</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Item Three</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Item Four</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Item Five</a>
        </li>
      </ul>
    </div>
    <div class="float-right">

    </div>
  </div>
  <div class="footer bg-light">

  </div>
</div>
<script src="https://kit.fontawesome.com/bec9f83658.js" crossorigin="anonymous"></script>
</body>
</html>