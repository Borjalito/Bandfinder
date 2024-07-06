// Creazione dei player per le tracce
const track1 = new Tone.Player("path/to/track1.mp3").toDestination();
const track2 = new Tone.Player("path/to/track2.mp3").toDestination();

// Funzioni per i controlli di playback
document.getElementById("play").addEventListener("click", () => {
    Tone.Transport.start();
    track1.start();
    track2.start();
});

document.getElementById("stop").addEventListener("click", () => {
    Tone.Transport.stop();
    track1.stop();
    track2.stop();
});

// Funzione per il mute e volume
document.querySelectorAll(".track").forEach(trackElement => {
    const trackId = trackElement.getAttribute("data-id");
    const player = trackId === "1" ? track1 : track2;
    
    trackElement.querySelector(".mute").addEventListener("click", () => {
        player.mute = !player.mute;
    });

    trackElement.querySelector(".volume").addEventListener("input", (event) => {
        player.volume.value = Tone.gainToDb(event.target.value);
    });
});
