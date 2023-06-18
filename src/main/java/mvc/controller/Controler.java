package mvc.controller;

import mvc.entity.OrderDetails;
import mvc.entity.OrderEntity;

import mvc.entity.ProductsEntity;
import mvc.repository.OrderDetailsRepository;
import mvc.repository.OrderRepository;
import mvc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class Controler {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderDetailsRepository orderDetailsRepository;
    @Autowired
    ProductRepository productRepository;
   @GetMapping(value = "/")
    public String showListOder(Model model){
       List<OrderEntity> list = (List<OrderEntity>) orderRepository.findAll();
       model.addAttribute("list", list);
       return "text";
   }
//   @GetMapping(value = "details/{orderId}")
//    public String details(@PathVariable int orderId, Model model){
////        List<OrderDetails> orderDetailsList = orderRepository.list(orderId);
////       System.out.println(orderDetailsList);
//       List<Object[]> orderDetailsData = orderDetailsRepository.list(orderId);
//        model.addAttribute("listOder", orderDetailsData);
//        return "details";
//
//   }
    @GetMapping(value = "/details/{orderId}")
   public String showDetails(@PathVariable int orderId, Model model){
       List<OrderDetails> orderDetailsList = orderDetailsRepository.findDetailsByOrderId(orderId);
       model.addAttribute("listOder", orderDetailsList);
       return "details";
   }
   @GetMapping(value = "/search")
   public String search (@RequestParam String search, Model model) {
//        List<OrderEntity> orderEntityList = orderRepository.findByCustomerNameContainingIgnoreCase(search);
       List<OrderEntity> orderEntityList =orderRepository.list_seach(search, search);
               System.out.println(orderEntityList);
        model.addAttribute("list", orderEntityList);
        return "text";
   }
   @GetMapping(value = "/add")
   public String add(Model model){
       model.addAttribute("orderDetail", new OrderDetails());
       model.addAttribute("action", "/add");
       setProduct(model);
       return "add";
   }
   @PostMapping(value = "/add")
   public String save(@ModelAttribute OrderDetails orderDetail, BindingResult bindingResult,  Model model){
//       if (bindingResult.hasErrors()){
//           setProduct(model);
//           return "redirect:/";
//       }
       System.out.println(orderDetail.getProduct());
       OrderEntity orderEntity = new OrderEntity();
       orderEntity.setCustomerName(orderDetail.getOrder().getCustomerName());
       orderEntity.setOrderDate(orderDetail.getOrder().getOrderDate());
       orderRepository.save(orderEntity);
       OrderDetails orderDetails = new OrderDetails();
       orderDetails.setOrder(orderEntity);
       orderDetails.setProduct(orderDetail.getProduct());
       orderDetails.setQuantity(orderDetail.getQuantity());

       orderDetailsRepository.save(orderDetails);



       return "redirect:/";

   }
    @GetMapping(value = "edit/{orderDetailsId}")
    public String edit(@PathVariable int orderDetailsId, Model model) {
        OrderDetails orderDetail = orderDetailsRepository.findById(orderDetailsId).get();
        model.addAttribute("orderDetail", orderDetail);
        model.addAttribute("action", "/edit");
        setProduct(model);
        return "add";
    }

    @PostMapping(value = "/edit")
    public String editSave(@ModelAttribute OrderDetails orderDetail) {
      OrderEntity orderEntity = orderRepository.findById(orderDetail.getOrder().getOrderId()).get();
      orderEntity.setCustomerName(orderDetail.getOrder().getCustomerName());
      orderEntity.setOrderDate(orderDetail.getOrder().getOrderDate());
      orderRepository.save(orderEntity);
      OrderDetails orderDetails = orderDetailsRepository.findById(orderDetail.getOrderDetailsId()).get();
      orderDetails.setOrder(orderEntity);
      orderDetails.setProduct(orderDetail.getProduct());
      orderDetails.setQuantity(orderDetail.getQuantity());

        orderDetailsRepository.save(orderDetail);
        return "redirect:/";
    }

   public void  setProduct (Model model){
       List<ProductsEntity> productsEntityList = (List<ProductsEntity>) productRepository.findAll();
       Map<Integer, String> map = new LinkedHashMap<>();
       for (ProductsEntity productsEntity : productsEntityList){
           map.put(productsEntity.getProductsId(), productsEntity.getProName());
       }

       model.addAttribute("map", map);
   }


}
