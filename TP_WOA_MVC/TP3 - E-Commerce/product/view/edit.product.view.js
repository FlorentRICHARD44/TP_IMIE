

var ProductEditView = function() {
    Observer.call(this);
    Subject.call(this);
    var self = this;

    $('button#list-product').on('click', function() {
        self.notifyObservers(EVENT_CTRL.LIST_PRODUCT);
        $('div#product-edit').attr("hidden", "");
    });

    $('button#save').on('click', function() {
        var p = new Product();
        p.setId($('input#id').val());
        p.setLabel($('input#label').val());
        p.setPrice($('input#price').val());
        p.setImageUrl($('input#imageUrl').val());
        self.notifyObservers(EVENT_CTRL.SAVE_PRODUCT, p);
        $('input#id').val("");      
        $('input#label').val("")  ;
        $('input#price').val(""); 
        $('input#imageUrl').val("");     
        $('div#product-edit').attr("hidden", "");
    });

    this.updateView = function(product) {
        $('div#product-edit').removeAttr("hidden");
    }
    this.notify = function(msg, val) {
        if (msg == EVENT_MODEL.NEW) {
            $('div#product-edit').removeAttr("hidden");
        } else if (msg == EVENT_MODEL.EDIT) {
            $('input#id').val(val.getId());      
            $('input#label').val(val.getLabel());
            $('input#price').val(val.getPrice()); 
            $('input#imageUrl').val(val.getImageUrl()); 
            $('div#product-edit').removeAttr("hidden");
        }
    }

};

