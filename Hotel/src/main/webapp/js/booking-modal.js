(function ($) {
    "use strict"; // Start of use strict
    $(document).ready(function () {
        $('#linkToShowModal').click();

        $('.close').click(function () {

            setTimeout(function () {
                window.location.href = "hotels.jsp";
            }, 500);
        })
    });

})(jQuery); // End of use strict
