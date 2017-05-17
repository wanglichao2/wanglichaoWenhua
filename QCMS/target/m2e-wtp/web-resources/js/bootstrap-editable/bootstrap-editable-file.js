/**
 File editable input.

 @class file
 @extends abstractinput
 @experimental
 @example
 <a href="#" id="file" data-type="file" data-pk="1">awesome</a>

 *Note that on the server side the json return needs to be returned in a <textarea> element
 in order to handle HTML dataType, status and .statusText.
 See http://github.com/cmlenz/jquery-iframe-transport for details.

 <script>
 $(function(){
$('#file').editable({
url: '/post',
title: 'Enter file, caption and url #',
});
});
 </script>
 **/

(function ($) {

    "use strict";

    var File = function (options) {
        this.init('file', options, File.defaults);
    };

    //inherit from Abstract input
    $.fn.editableutils.inherit(File, $.fn.editabletypes.abstractinput);

    $.extend(File.prototype, {
        /**
         Renders input from tpl

         @method render()
         **/
        render: function() {
            this.$input = this.$tpl.find('input');
           // this.$input.parents('td').find('form.editableform').attr('enctype','multipart/form-data');
            this.$input.filter('[name="file"]').bind('change focus click', function() {
                var $this = $(this),
                    newVal = $this.val().split(/\s+/).pop(),
                    $button = $this.siblings('button');
                if(newVal !== '') {
                    //$button.text(newVal);
                }
            });

        },

        /**
         Default method to show value in element. Can be overwritten by display option.

         @method value2html(value, element)
         **/
        value2html: function(value, element) {
            if(!value) {
                $(element).empty();
                return;
            }

            //@TODO Not sure what to return here since you can't set value of type=file
            //For images I would construct and image elemnt and link
            var html = '';
            $(element).html(html);
        },

        /**
         Gets value from element's html

         @method html2value(html)
         **/
        html2value: function(html) {
            /*
             you may write parsing method to get value by element's html
             */
            return null;
        },

        /**
         Converts value to string.
         It is used in internal comparing (not for sending to server).

         @method value2str(value)
         **/
        value2str: function(value) {
            var str = '';
            if(value) {
                for(var k in value) {
                    str = str + k + ':' + value[k] + ';';
                }
            }
            return str;
        },

        /*
         Converts string to value. Used for reading value from 'data-value' attribute.

         @method str2value(str)
         */
        str2value: function(str) {
            /*
             this is mainly for parsing value defined in data-value attribute.
             If you will always set value by javascript, no need to overwrite it
             */
            return str;
        },

        /**
         Sets value of input.

         @method value2input(value)
         @param {mixed} value
         **/
        value2input: function(value) {
            if(!value) {
                return;
            }
            //this.$input.filter('[name="file"]').val(value.file);
            this.$input.filter('[name="caption"]').val(value.caption);
            this.$input.filter('[name="url"]').val(value.url);
        },

        /**
         Returns value of input.

         @method input2value()
         **/
        input2value: function() {
            return {
                file: this.$input.filter('[name="file"]').val(),
            };
        },

        /**
         Activates input: sets focus on the first field.

         @method activate()
         **/
        activate: function() {

            //Set file specific option and success callback to load new file reference
            //Hard to know if the file is remote so just force the send
            $(this.options.scope).editable('option', 'savenochange', true );
            //iframe transport specific ajaxOptions.
            $(this.options.scope).editable('option', 'ajaxOptions', {
                dataType: 'json',
                iframe: true,
                files: this.$input.filter('[name="file"]')
            });

            this.$input.filter('[name="file"]').focus();
        },

        /**
         Attaches handler to submit form in case of 'showbuttons=false' mode

         @method autosubmit()
         **/
        autosubmit: function() {
            this.$input.keydown(function (e) {
                if (e.which === 13) {
                    $(this).closest('form').submit();
                }
            });
        }
    });

    File.defaults = $.extend({}, $.fn.editabletypes.abstractinput.defaults, {
        tpl: '<div class="editable-file">' +
            '<span style="position:relative; display: inline-block; overflow: hidden; cursor: pointer;">' +
            '<input type="file" name="file" class="input-small" size="1" style="opacity: 0;filter: alpha(opacity=0); cursor: pointer; font-size: 400%; height: 600%; position: absolute; top: 0; right: 0; width: 240%" />' +
            '<button type="button" style="cursor: pointer; display: inline-block; margin-right: 5px;  ">Chose file</button>' +
            '</span></div>',

        inputclass: '',

    });

    $.fn.editabletypes.file = File;

}(window.jQuery));