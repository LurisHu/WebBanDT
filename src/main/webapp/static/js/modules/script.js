'use strict';

$(document).ready(function() {

    // Default option
    var option = '<option value="0" selected="selected">Tùy chọn</option>';
    
    // Method to clear dropdowns down to a given level
    var clearDropDown = function(arrayObj, startIndex) {
        $.each(arrayObj, function(index, value) {
            if(index >= startIndex) {
                $(value).html(option);
            }
        });
    };

    // Method to disable dropdowns down to a given level
    var disableDropDown = function(arrayObj, startIndex) {
        $.each(arrayObj, function(index, value) {
            if(index >= startIndex) {
                $(value).attr('disabled', 'disabled');
            }
        });
    };

    // Method to disable dropdowns down to a given level
    var enableDropDown = function(that) {
        that.removeAttr('disabled');
    };

    // Method to generate and append options
    var generateOptions = function(element, selection, limit) {
        var options = '';
        for(var i = 1; i <= limit; i++) {
            options += '<option value="' + i + '">Option ' + selection + '-' + i + '</option>';
        }
        
        element.append(options);
    };
    
    var generateDistricts = function(element, selection) {
    	selection=selection.substring(0,selection.indexOf("-"))
        $(document).ready(function() {
			$.get('http://localhost:8080/api/city/'+selection+'/district')
			.then(function(response){
				for(i=0;i<response.LtsItem.length;i++){
					element.append("<option value='"+response.LtsItem[i].ID+"-"+response.LtsItem[i].Title+"'>"+response.LtsItem[i].Title+"</option>");
				}
			});
		});
    };
    
    var generateWards = function(element, selection) {
    	selection=selection.substring(0,selection.indexOf("-"))
        $(document).ready(function() {
			$.get('http://localhost:8080/api/district/'+selection+'/ward')
			.then(function(response){
				for(i=0;i<response.LtsItem.length;i++){
					if(response.LtsItem[i].Title!="Chưa rõ"){
						element.append("<option value='"+response.LtsItem[i].ID+"-"+response.LtsItem[i].Title+"'>"+response.LtsItem[i].Title+"</option>");
					}
				}
			});
		});
    };

    // Select each of the dropdowns
    var firstDropDown = $('#first');
    var secondDropDown = $('#second');
    var thirdDropDown = $('#third');

    // Hold selected option
    var firstSelection = '';
    var secondSelection = '';
    var thirdSelection = '';

    // Hold selection
    var selection = '';

    // Selection handler for first level dropdown
    firstDropDown.on('change', function() {

        // Get selected option
        firstSelection = firstDropDown.val();

        // Clear all dropdowns down to the hierarchy
        clearDropDown($('select'), 1);

        // Disable all dropdowns down to the hierarchy
        disableDropDown($('select'), 1);

        // Check current selection
        if(firstSelection === '0') {
            return;
        }

        // Enable second level DropDown
        enableDropDown(secondDropDown);

        // Generate and append options
        selection = firstSelection;
        generateDistricts(secondDropDown, selection);
    });

    // Selection handler for second level dropdown
    secondDropDown.on('change', function() {
        secondSelection = secondDropDown.val();

        // Clear all dropdowns down to the hierarchy
        clearDropDown($('select'), 2);

        // Disable all dropdowns down to the hierarchy
        disableDropDown($('select'), 2);

        // Check current selection
        if(secondSelection === '0') {
             return;
        }

        // Enable third level DropDown
        enableDropDown(thirdDropDown);

        // Generate and append options
        selection = secondSelection;
        generateWards(thirdDropDown, selection);
    });

    // Selection handler for third level dropdown
    thirdDropDown.on('change', function() {
        thirdSelection = thirdDropDown.val();

        console.log(thirdSelection);
        // Final work goes here

     });

    /*
     * In this way we can make any number of dependent dropdowns
     *
     */

});
