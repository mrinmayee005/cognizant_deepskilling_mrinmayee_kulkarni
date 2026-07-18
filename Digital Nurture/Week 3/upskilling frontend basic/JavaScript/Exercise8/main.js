const events = [
    { name: "Summer Music Festival", category: "music", date: "2026-08-15", seats: 50 },
    { name: "Community Garden Day", category: "outdoor", date: "2026-07-20", seats: 30 },
    { name: "Tech Meetup", category: "tech", date: "2026-09-10", seats: 25 },
    { name: "Art in the Park", category: "art", date: "2026-08-25", seats: 40 },
    { name: "Jazz Night", category: "music", date: "2026-08-30", seats: 35 },
    { name: "Food Truck Rally", category: "food", date: "2026-08-01", seats: 60 }
];

function renderEventList(filteredEvents) {
    const container = document.getElementById("eventList");
    container.innerHTML = "";
    (filteredEvents || events).forEach(function (event, index) {
        const row = document.createElement("div");
        row.className = "event-row";

        const info = document.createElement("span");
        info.innerHTML = `<strong>${event.name}</strong> - ${event.category} | ${event.date} | Seats: ${event.seats}`;

        const btn = document.createElement("button");
        btn.textContent = "Register";
        btn.setAttribute("onclick", `registerForEvent(${index})`);

        row.appendChild(info);
        row.appendChild(btn);
        container.appendChild(row);
    });
}

function registerForEvent(index) {
    const event = events[index];
    if (event.seats > 0) {
        event.seats--;
        const msg = document.getElementById("regMessage");
        msg.style.display = "block";
        msg.textContent = `Registered for ${event.name}! ${event.seats} seats remaining.`;
        renderEventList();
    } else {
        alert("Sorry, this event is full!");
    }
}

const searchInput = document.getElementById("searchInput");
searchInput.addEventListener("keydown", function (e) {
    const query = e.target.value.toLowerCase();
    const results = events.filter(function (event) {
        return event.name.toLowerCase().includes(query) || event.category.toLowerCase().includes(query);
    });

    const container = document.getElementById("searchResults");
    if (query.length === 0) {
        container.innerHTML = "";
    } else {
        container.innerHTML = results.map(function (event) {
            return `<div style="padding:0.3rem;border-bottom:1px solid #eee;">${event.name} (${event.category})</div>`;
        }).join("") || "<p>No events found.</p>";
    }

    const log = document.getElementById("keyLog");
    log.innerHTML += `<div>Key: ${e.key} | Code: ${e.code}</div>`;
    log.scrollTop = log.scrollHeight;
});

const categoryFilter = document.getElementById("categoryFilter");
categoryFilter.addEventListener("change", function (e) {
    const category = e.target.value;
    let filtered = events;
    if (category) {
        filtered = events.filter(function (event) {
            return event.category === category;
        });
    }
    renderEventList(filtered);
    const container = document.getElementById("filterResults");
    container.innerHTML = `<p>Showing ${filtered.length} event(s) in category "${category || "all"}"</p>`;
});

renderEventList();
