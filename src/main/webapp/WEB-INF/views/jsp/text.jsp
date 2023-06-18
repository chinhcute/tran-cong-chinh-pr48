<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

   <!DOCTYPE html>
   <html>
   <head>
   <meta charset="ISO-8859-1">
   <title>Insert title here</title>
   <meta charset="UTF-8">

       <title>Document</title>
       <style>
           * {
               margin: 0;
           }
           header{
               position: absolute;
               width: 1350px;
               height: 70px;
               background-color:rgb(124, 211, 218);
               z-index: 1;
           }
           nav{
               position: absolute;
               width: 250px;
               height: 1000px;
               background-color: rgb(51, 152, 159);
               z-index: 2;
           }
           header article a{
               margin-left: 60px;
           }
           header {
               display: flex;
               justify-content: space-around;
           }
           a{
               text-decoration: none;
           }
           ul li {
               list-style: none;
               margin-top: 0 50px;
           }
           nav , ul li a{
               color: aliceblue;
               font-weight: 100;
           }
           ul li {
               margin: 40px 0;
           }
           hr{
               height: 0.5px;
           }
           main {
               height: 1000px;
               width: 1100px;
               background-color: aqua;
               margin:80px 260px;
               position: absolute;

           }
           table, th, td {
     border: 1px solid black;
     /* border-collapse: collapse; */

   }
        tr td{
           margin-left: 20px;
       }
       </style>
   </head>
   <body>
     <header>
           <article style=" width: 600px; height: 30px;padding-top: 13px; padding-left: 300px;">
                <form action="search" method="get">
                    <input style="height: 30px; width: 500px;" tabindex="1" type="text" name="search" placeholder="nhập dữ liệu" autofocus>
                    <input type="submit" style="height: 30px; width: 60px;" placeholder="ok" tabindex="2">
                </form>

           </article>
           <article style="padding-top: 15px;">
              <a href=""><i class="fa-solid fa-bell"></i></a>
               <a href=""><i class="fa-solid fa-message"></i></a>
           </article>
       </header>
       <nav >

               <img style="margin: 10px 75px" width="93px"  src="https://www.carlsbergvietnam.vn/media/18386/logo-cbvn-xanh-567c.png" alt="">
               <hr>
              <section style="margin: 0 30px;">
               <p style="margin: 30px 20px;" >
                   <i class="fa-solid fa-house"></i>
                   Dashboard
               </p>
               <hr>
             <article  style="margin: 20px 30px;">
               <dl>
                   <dt>
                       Interfake
                   </dt>
                   <dd>
                       <ul>
                           <li> <a href="">Components</a></li>

                           <li><a href="">Amin profile</a></li>

                           <li><a href="">Utilltes</a></li>

                       </ul>
                   </dd>
               </dl>
             </article>
             <hr>
             <article  style="margin: 20px 30px;">
               <dl>
                   <dt>
                       Addors
                   </dt>
                   <dd>
                       <ul>
                           <li> <a href="">Pages</a></li>

                           <li><a href="">Charts</a></li>

                           <li><a href="">Table</a></li>

                       </ul>
                   </dd>
               </dl>
             </article>
             <hr>
              </section>
       </nav>
       <main >
           <section style="display: flex;">
               <p style="height: 30px; width: 90px; background-color: red; font-size: 15px;  padding: 5px 0 0 6px  ; box-sizing: border-box;"><a href="/add">Add</a> </p>
               <p style="height: 30px; width: 90px; background-color: rgb(79, 181, 219); font-size: 15px; padding: 5px 0 0 6px  ; box-sizing: border-box;"> Amin Profile</p>
           </section>
           <hr style="margin: 10px 0;">
           <table  style="width: 1000px; border-collapse: collapse; margin: 20px 30px;">
               <tr>
                   <td>orderId</td>
                   <td>orderDate</td>
                   <td>customerName</td>
                   <td>view Details</td>



               </tr>
              <c:forEach items="${list}" var="order">
                  <tr>
                      <th>${order.orderId}</th>
                      <th>${order.orderDate}</th>
                      <th>${order.customerName}</th>
                      <th>
                          <a href="details/${order.orderId}">
                              viewDetails
                          </a>
                      </th>



                  </tr>
              </c:forEach>



           </table>


       </main>
   </body>
   </html>