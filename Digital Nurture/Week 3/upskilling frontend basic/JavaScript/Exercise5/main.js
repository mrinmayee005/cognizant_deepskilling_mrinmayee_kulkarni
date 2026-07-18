class Event {
    constructor(name, date, category, seats) {
        this.name = name;
        this.date = date;
        this.category = category;
        this.seats = seats;
    }

    checkAvailability() {
        return this.seats > 0 ? `${this.name} is available (${this.seats} seats left)` : `${this.name} is sold out`;
    }

    register() {
        if (this.seats > 0) {
            this.seats--;
            return true;
        }
        return false;
    }

    getInfo() {
        return `${this.name} - ${this.date} (${this.category})`;
    }
}

const events = [
    new Event("Summer Music Festival", "2026-08-15", "music", 50),
    new Event("Community Garden Day", "2026-07-20", "outdoor", 30),
    new Event("Tech Meetup", "2026-09-10", "tech", 25),
    new Event("Art in the Park", "2026-08-25", "art", 40)
];

function renderEventCards() {
    const container = document.getElementById("eventCards");
    container.innerHTML = "";
    events.forEach(function (event) {
        const card = document.createElement("div");
        card.className = "event-card";
        card.innerHTML = `<strong>${event.name}</strong><br>Date: ${event.date} | Category: ${event.category} | Seats: ${event.seats}`;
        container.appendChild(card);
    });
}

function renderProperties() {
    const list = document.getElementById("propsList");
    list.innerHTML = "";
    events.forEach(function (event) {
        Object.entries(event).forEach(function ([key, value]) {
            const li = document.createElement("li");
            li.textContent = `${key}: ${value}`;
            list.appendChild(li);
        });
    });
}

function checkAllAvailability() {
    const result = document.getElementById("availabilityResult");
    result.innerHTML = events.map(function (event) {
        return event.checkAvailability();
    }).join("<br>");
}

renderEventCards();
renderProperties();
