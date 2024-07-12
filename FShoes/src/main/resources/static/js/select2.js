(function($) {
  'use strict';

  if ($(".js-example-basic-single").length) {
    $(".js-example-basic-single").select2();
  }
  if ($(".js-example-basic-multiple").length) {
    $(".js-example-basic-multiple").select2();
  }
  $('.js-example-basic-multiple').on('change', function() {
    generateProductDetails();
  });


  function generateProductDetails() {
    var sizeSelect = document.getElementById('sizeSelect');
    var colorSelect = document.getElementById('colorSelect');
    var productDetailsBody = document.getElementById('productDetailsBody');
    var productName = $('#nameShoe').val();
    var categoryId = $('#categoryId').val();
    var categoryName = $('#categoryId option:selected').text();
    var brandName = $('#brandId option:selected').text();
    var brandId = $('#brandId').val();
    productDetailsBody.innerHTML = ''; // Xóa các dòng cũ

    // Lặp qua các size đã chọn
    Array.from(sizeSelect.selectedOptions).forEach(function(sizeOption) {
      // Lặp qua các color đã chọn
      Array.from(colorSelect.selectedOptions).forEach(function(colorOption) {
        // Tạo một dòng mới cho sản phẩm chi tiết
        var newRow = document.createElement('tr');
        newRow.innerHTML = `
                <td>${productName}</td>
                <td ><input  type="number" class="form-control" name="quantity" data-size="${sizeOption.value}" data-color="${colorOption.value}"></td>
                <td><input type="number" class="form-control" name="price" data-size="${sizeOption.value}" data-color="${colorOption.value}"></td>
               
                <td>${sizeOption.textContent}</td>
                <td>${colorOption.textContent}</td>
                 <td><input type="file" class="form-control" name="productImage" data-size="${sizeOption.value}" data-color="${colorOption.value}"></td>
                  <td class="text-danger delete-row"><i class="ti-close" style="margin-right: 15px"></i></td>
            `;
        productDetailsBody.appendChild(newRow); // Thêm dòng vào tbody
        var deleteBtn = newRow.querySelector('.delete-row');
        deleteBtn.addEventListener('click', function() {
          newRow.remove(); // Xóa dòng khi click vào nút xóa
        });
        console.log(newRow)
      });
    });
  }

})(jQuery);

