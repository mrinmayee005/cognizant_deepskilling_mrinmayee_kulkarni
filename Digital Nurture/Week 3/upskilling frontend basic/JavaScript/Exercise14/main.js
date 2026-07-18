// jQuery-based Community Event Portal

$(document).ready(function () {
    console.log("jQuery ready! DOM loaded.");

    const events = [
        { name: "Summer Music Festival", category: "music", date: "2026-08-15", seats: 50, description: "Three days of live music in the park." },
        { name: "Community Garden Day", category: "outdoor", date: "2026-07-20", seats: 30, description: "Help us plant and maintain community gardens." },
        { name: "Tech Meetup", category: "tech", date: "2026-09-10", seats: 25, description: "Network with local developers and designers." },
        { name: "Art in the Park", category: "art", date: "2026-08-25", seats: 40, description: "Outdoor painting and sculpture workshop." },
        { name: "Food Truck Rally", category: "food", date: "2026-08-01", seats: 60, description: "Taste dishes from 20+ local food trucks." }
    ];

    // Render event cards using jQuery
    function renderCards() {
        const $container = $("#eventCards");
        $container.empty();

        events.forEach(function (event, index) {
            const $card = $("<div>").addClass("event-card").attr("data-index", index);
            $card.append($("<h3>").text(event.name));
            $card.append($("<p>").text(`${event.category} | ${event.date} | ${event.seats} seats`));
            $card.append($("<p>").text(event.description).hide());
            $container.append($card);
        });

        // Click to toggle details on individual cards
        $(".event-card").on("click", function () {
            $(this).find("p:last").slideToggle(300);
        });
    }

    // Show All / Hide All buttons
    $("#showAllBtn").on("click", function () {
        $(".event-card").fadeIn(400);
    });

    $("#hideAllBtn").on("click", function () {
        $(".event-card").fadeOut(400);
    });

    // Fade In / Fade Out notification
    $("#fadeInBtn").on("click", function () {
        $("#notification").fadeIn(500);
        setTimeout(function () {
            $("#notification").fadeOut(1000);
        }, 2000);
    });

    $("#fadeOutBtn").on("click", function () {
        $("#notification").fadeOut(300);
    });

    // Slide toggle
    $("#slideBtn").on("click", function () {
        $("#slideDetails").slideToggle(400);
    });

    // Register button with jQuery click handler
    $("#registerBtn").on("click", function () {
        const $btn = $(this);
        const $msg = $("#regMessage");

        $btn.prop("disabled", true).text("Processing...");

        setTimeout(function () {
            $btn.prop("disabled", false).text("Register Interest");
            $msg.text("Thank you! You've been registered for updates.").hide().fadeIn(500);

            setTimeout(function () {
                $msg.fadeOut(1000);
            }, 3000);
        }, 1000);
    });

    // Additional jQuery utilities demonstrated
    console.log("Total events:", events.length);

    // jQuery .each()
    console.log("Events (jQuery .each):");
    $.each(events, function (index, event) {
        console.log(`  ${index + 1}. ${event.name}`);
    });

    // jQuery .map()
    const eventNames = $.map(events, function (event) {
        return event.name;
    });
    console.log("Event names:", eventNames);

    // jQuery .filter()
    const musicEvents = $(events).filter(function (i, event) {
        return event.category === "music";
    });
    console.log("Music events:", musicEvents);

    // jQuery .grep()
    const techEvents = $.grep(events, function (event) {
        return event.category === "tech";
    });
    console.log("Tech events:", techEvents);

    renderCards();
});
