const input = document.getElementById('input');
const btn = document.getElementById('btn');
const meaning = document.getElementById('meaning');
const word = document.getElementById('word');
const lower = document.getElementById('lower')

btn.addEventListener('click', () => {
    if (input.value == "") {
        alert("Input field is empty");
    } else {
        word.innerHTML = input.value;
        fetchWord(input.value);
    }
})


const fetchWord = async (word) => {
    meaning.innerHTML = ""
    lower.innerHTML = ""
    try {

        const res = await fetch("https://api.dictionaryapi.dev/api/v2/entries/en/" + word)
        const data = await res.json()
        console.log(data)
        let sound = data[0].phonetics[0].audio
        const meanArr = data[0].meanings[0].definitions;

        meanArr.forEach((ele, index) => {
            const li = document.createElement('li')
            li.innerHTML = `
           
       ${ele.definition}
       `
            meaning.appendChild(li)

        })

        if (sound) {
            const soundBtn = document.createElement('button');
            soundBtn.classList.add('btn','btn-dark')
            soundBtn.innerHTML = `<i class="fa-solid fa-microphone"></i>`
            lower.appendChild(soundBtn)

            soundBtn.addEventListener('click', () => {
                let audio = new Audio(sound)
                audio.play(sound)
            })
        }


    } catch (err) {
        console.log(err)
        meaning.innerHTML = `<p>Sorry We can not find this word!!</p>`
    }


}

