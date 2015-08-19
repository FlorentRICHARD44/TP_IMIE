
// View for the List of Product.
var ProductListView = function(model) {
    Observer.call(this);
    Subject.call(this);
    var self = this;
    
    // Notify called by subject.
    this.notify = function(msg) {
        if (msg == EVENT_MODEL.LIST_UPDATED) {
            this.show();   
        }
    }

    // BUTTON: NEW
    $('button#new-product').on('click', function() {
        self.notifyObservers(EVENT_CTRL.NEW_PRODUCT);
    });

    // Hide this view
    this.hide = function() {
        $('div#product-list').hide();
    }

    // Show this view
    this.show = function() {
        var pList = model.getProductList();
        $('div#product-list tbody').text('');
        for (var p_index in pList) {
            var btnEdit = $('<button>').addClass('btn')
                                       .addClass('btn-primary')
                                       .append($('<span>').addClass('glyphicon')
                                                          .addClass('glyphicon-pencil'))
                                       .on('click', (function(copieProduct) { 
                                            return function() {
                                                $('div#product-list').attr("hidden", "");
                                                self.notifyObservers(EVENT_CTRL.EDIT_PRODUCT, copieProduct);
                                            }
                                        })(pList[p_index]));
            var btnDel = $('<button>').addClass('btn')
                                      .addClass('btn-danger')
                                      .append($('<span>').addClass('glyphicon')
                                                         .addClass('glyphicon-trash'))
                                      .on('click', (function(copieProduct) { 
                                           return function() {
                                               self.notifyObservers(EVENT_CTRL.DEL_PRODUCT, copieProduct);
                                           }
                                      })(pList[p_index]));
            var line = $('<tr>').append($('<td>').addClass("vert-align")
                                                 .append($('<img>').addClass("product")
                                                                   .attr("src", pList[p_index].imageUrl)
                                                                   .attr("alt", pList[p_index].label)))
                                .append($('<td>').addClass("vert-align")
                                                 .text(pList[p_index].id))
                                .append($('<td>').addClass("vert-align")
                                                 .text(pList[p_index].label))
                                .append($('<td>').addClass("vert-align")
                                                 .text(pList[p_index].price))
                                .append($('<td>').addClass("vert-align")
                                                 .append(btnEdit)
                                                 .append(btnDel));
            $('div#product-list tbody').append(line);
        }
        $('div#product-list').show();
    }
};

