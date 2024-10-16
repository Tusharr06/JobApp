<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.tushar.JobApp.model.JobPost" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Job Post Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <style>
        body {
            background-color: #f8f9fa;
            font-family: Arial, sans-serif;
        }
        .card {
            border: 2px solid #343a40;
            background-color: #ffffff;
            margin-bottom: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
        }
        .navbar {
            background-color: #f1faee;
        }
        .navbar-brand {
            font-size: 1.5rem;
        }
        h2 {
            color: #343a40;
        }
        .text-danger {
            font-weight: bold;
        }
    </style>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light">
    <div class="container">
        <a class="navbar-brand" href="#">Job Portal Web App</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a class="nav-link" href="home">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="viewalljobs">All Jobs</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<%
JobPost jobPost = (JobPost) request.getAttribute("jobPost");
if (jobPost == null) {
    out.println("<div class='container mt-5'><p class='text-danger'>No job post found.</p></div>");
    return;
}
%>

<div class="container mt-5">
    <h2 class="mb-4 text-center fw-bold">Job Post Details</h2>
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">${jobPost.getPostProfile()}</h5>
                    <p class="card-text">
                        <strong>Job ID:</strong> ${jobPost.getPostId()}
                    </p>
                    <p class="card-text">
                        <strong>Description:</strong> ${jobPost.getPostDesc()}
                    </p>
                    <p class="card-text">
                        <strong>Experience Required:</strong> ${jobPost.getReqExperience()} years
                    </p>
                    <p class="card-text">
                        <strong>Tech Stack Required:</strong>
                        <ul>
                            <c:forEach var="tech" items="${jobPost.getPostTechStack()}">
                                <li>${tech}</li>
                            </c:forEach>
                        </ul>
                    </p>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>
