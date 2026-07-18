const eventName = "Summer Music Festival";
const eventDate = "2026-08-15";
let seats = 50;

document.getElementById("eventName").textContent = eventName;
document.getElementById("eventDate").textContent = eventDate;

function updateDisplay() {
    const message = `${eventName} on ${eventDate} has ${seats} seat${seats !== 1 ? "s" : ""} remaining.`;
    document.getElementById("eventMessage").textContent = message;
    document.getElementById("seatDisplay").textContent = seats;
}

function incrementSeats() {
    seats++;
    updateDisplay();
}

function decrementSeats() {
    if (seats > 0) {
        seats--;
    }
    updateDisplay();
}

updateDisplay();
