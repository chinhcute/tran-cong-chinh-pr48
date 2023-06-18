<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        *{
            font-family: Arial, Helvetica, sans-serif;
            margin: 0;
        }
        header{
            height: 100px;
            width: 100%;
            background-color: aqua;
            display: flex;
            justify-content: space-between;
        }
        header section img{
            margin-left: 10px;
        }
        nav{
            height: 100px;

        }
        nav ul{
            display: flex;

        }
        li{
            list-style: none;
            height: 100px;
            width: 150px;
            padding: 30px;
            box-sizing: border-box;
        }
        li:hover{
          background-image: rgb(224, 175, 15);
          color: aliceblue;
        }
        .form {
            display: flex;
            margin: 100px;
        }
        .class1 div{
            margin: 23px 100px;
        }
        .class2 div{
            margin: 20px 100px;
        }


        footer{
            height: 100px;
            width: 100%;
            background-color: rgb(29, 166, 166);

        }


    </style>
</head>

<body>
    <header>
        <section>
            <img style="margin-left: 100px;" src="https://png.pngtree.com/png-vector/20210414/ourlarge/pngtree-beauty-logo-png-image_3209241.jpg" alt="hinh anh" height="100px">
        </section>
        <nav>
            <ul>
                <li>Home</li>
                <li>Subdivisions</li>
                <li>Blog</li>
                <li>About</li>
                <li>Register</li>
            </ul>
        </nav>
    </header>

        <main>
            <section>
                <form:form  class="form" action="${action}" method="post" modelAttribute="orderDetail">
                    <legend>Register</legend>

                    <div class="class1">
                        <div><label for="CustomerName">CustomerName</label></div>
                        <div><label for="orderDate">orderDate</label></div>


                        <div><label for="quantity">quantity</label></div>
                       <div> <label for="product">Choose a product:</label></div>
                         <div> <input type="submit" placeholder="Submit"></div>
                    </div>
                    <div class="class2">
                        <div>
                            <form:input type="text" path="order.customerName" id="CustomerName" tabindex="1" autofocus="true" />
                        </div>

                        <div>
                            <form:input type="date" path="order.orderDate" id="orderDate" tabindex="2" />
                        </div>

                        <div>
                            <form:input type="number" path="quantity" id="quantity" tabindex="4"  />
                        </div>
                         <div>
                             <form:select path="product.productsId" id="product">
                                 <form:option value="0" label="Select a product" />
                                 <form:options items="${map}" />
                             </form:select>
                         </div>


                        <div>
                            <button type="disabled" autofocus required>Cancel</button>
                        </div>
                    </div>
                </form:form>


            </section>
        </main>

        <footer>
            <p style="margin: 50px; color: aliceblue;">&copy Hesitale to ask for help on the Forums</p>
        </footer>


</body>
</html>