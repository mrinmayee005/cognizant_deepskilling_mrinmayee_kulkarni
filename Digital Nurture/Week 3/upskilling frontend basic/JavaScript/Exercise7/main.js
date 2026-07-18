let events = [
    { name: "Summer Music Festival", category: "music", date: "2026-08-15", seats: 50, description: "Live music performances all day." },
    { name: "Community Garden Day", category: "outdoor", date: "2026-07-20", seats: 30, description: "Help plant flowers in the park." },
    { name: "Tech Meetup", category: "tech", date: "2026-09-10", seats: 25, description: "Networking for local developers." },
    { name: "Art in the Park", category: "art", date: "2026-08-25", seats: 40, description: "Outdoor painting workshop." }
];

function renderEvents() {
    const container = document.getElementById("eventContainer");
    container.innerHTML = "";

    events.forEach(function (event) {
        const card = document.createElement("div");
        card.className = "event-card";

        const title = document.createElement("h3");
        title.textContent = event.name;

        const category = document.createElement("p");
        category.textContent = `Category: ${event.category}`;

        const date = document.createElement("p");
        date.textContent = `Date: ${event.date}`;

        const seats = document.createElement("p");
        seats.className = "seats";
        seats.textContent = `Seats: ${event.seats}`;

        const desc = document.createElement("p");
        desc.textContent = event.description;

        card.appendChild(title);
        card.appendChild(category);
        card.appendChild(date);
        card.appendChild(seats);
        card.appendChild(desc);

        container.appendChild(card);
    });
}

const sampleEvents = [
    { name: "Food Truck Rally", category: "food", date: "2026-08-01", seats: 60, description: "Taste food from local vendors." },
    { name: "Yoga in the Park", category: "wellness", date: "2026-09-15", seats: 20, description: "Morning yoga session for all levels." },
    { name: "Book Club Meeting", category: "education", date: "2026-07-25", seats: 15, description: "Discuss this month's read." }
];

function addSampleEvent() {
    if (sampleEvents.length > 0) {
        events.push(sampleEvents.shift());
        renderEvents();
    }
}

function clearEvents() {
    events = [];
    renderEvents();
}

function sortEvents() {
    events.sort(function (a, b) {
        return a.name.localeCompare(b.name);
    });
    renderEvents();
}

renderEvents();
