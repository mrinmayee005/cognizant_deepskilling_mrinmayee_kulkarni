const events = [
    { name: "Summer Music Festival", date: "2026-08-15", category: "music", seats: 5, full: false },
    { name: "Community Garden Day", date: "2026-07-20", category: "outdoor", seats: 20, full: false },
    { name: "Art in the Park", date: "2025-12-01", category: "art", seats: 15, full: false },
    { name: "Tech Meetup", date: "2026-09-10", category: "tech", seats: 0, full: true },
    { name: "Food Truck Rally", date: "2026-08-01", category: "food", seats: 30, full: false }
];

function renderEvents() {
    const list = document.getElementById("eventList");
    list.innerHTML = "";
    const select = document.getElementById("regEvent");
    select.innerHTML = "";

    events.forEach(function (event) {
        const today = new Date().toISOString().split("T")[0];
        const isPast = event.date < today;

        let statusClass = "";
        if (isPast) statusClass = "past";
        else if (event.full || event.seats <= 0) statusClass = "full";

        if (!isPast && !event.full && event.seats > 0) {
            const option = document.createElement("option");
            option.value = event.name;
            option.textContent = event.name;
            select.appendChild(option);
        }

        const card = document.createElement("div");
        card.className = `event-card ${statusClass}`;
        card.innerHTML = `<strong>${event.name}</strong><br>Date: ${event.date} | Category: ${event.category} | Seats: ${event.seats}${isPast ? " (Past Event)" : ""}${event.full ? " (Full)" : ""}`;
        list.appendChild(card);
    });
}

function registerUser() {
    const name = document.getElementById("regName").value;
    const email = document.getElementById("regEmail").value;
    const eventName = document.getElementById("regEvent").value;
    const msg = document.getElementById("regMessage");

    try {
        if (!name || !email || !eventName) {
            throw new Error("Please fill in all fields.");
        }
        if (!email.includes("@")) {
            throw new Error("Please enter a valid email address.");
        }

        const event = events.find(function (e) { return e.name === eventName; });
        if (!event) {
            throw new Error("Event not found.");
        }
        if (event.seats <= 0) {
            throw new Error("Sorry, this event is full.");
        }

        event.seats--;
        msg.className = "success";
        msg.textContent = `Successfully registered ${name} for ${eventName}!`;
        renderEvents();
    } catch (error) {
        msg.className = "error";
        msg.textContent = error.message;
    }
}

renderEvents();
