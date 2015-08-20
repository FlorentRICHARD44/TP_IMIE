
// View for the Production Edition
var ProductEditView = function() {
    Observer.call(this);
    Subject.call(this);
    var self = this;

    // Button: go to List.
    $('button#list-product').on('click', function() {
        self.notifyObservers(EVENT_CTRL.LIST_PRODUCT);
    });

    // Button: SAVE
    $('button#save').on('click', function() {
        var error = false;
        var p = new Product();
        p.id = $('input#id').val();
        if ($('input#label').val() == "") {
            error = true;
        } else {
            p.label = $('input#label').val();
        }
        if ($('input#price').val() == "") {
            error = true;
        } else {
            p.price = $('input#price').val();
        }
        p.imageUrl = $('input#imageUrl').val();
        if (error) {
            $('div#edit-alert').show();
        } else {
            self.notifyObservers(EVENT_CTRL.SAVE_PRODUCT, p);
            $('input#id').val("");      
            $('input#label').val("")  ;
            $('input#price').val(""); 
            $('input#imageUrl').val("");
            $('div#edit-alert').hide();
        }
    });

    // Show the view
    this.show = function(product) {
        $('div#product-edit').show();
    }

    // Hide the view
    this.hide = function(product) {
        $('div#product-edit').hide();
    }

    // Notify called by subject
    this.notify = function(msg, val) {
        if (msg == EVENT_MODEL.NEW) {
            $('input#id').val("");      
            $('input#label').val(val.label);
            $('input#price').val(val.price); 
            $('input#imageUrl').val(val.imageUrl);
        } else if (msg == EVENT_MODEL.EDIT) {
            $('input#id').val(val.id);      
            $('input#label').val(val.label);
            $('input#price').val(val.price); 
            $('input#imageUrl').val(val.imageUrl);
        }
    }
};

