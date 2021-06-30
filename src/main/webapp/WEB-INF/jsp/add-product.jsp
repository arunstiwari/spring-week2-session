<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Add Product Page</title>
    <style>
        .error{
            color: tomato;
        }
    </style>
</head>
<body>
<div>
    <a href="/show-products">Show All Products</a>
</div>
<div>
    <form:form modelAttribute="product">
        <div>
            <label for="name">Name</label>
            <form:input path="name"></form:input>
            <form:errors path="name" cssClass="error"></form:errors>
        </div>
        <div>
            <label for="price">Price</label>
            <form:input path="price"></form:input>
        </div>
        <div>
            <form:button>Save Product</form:button>
        </div>
    </form:form>
</div>

</body>
</html>