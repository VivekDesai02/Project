const typingtext = document.querySelector('.typing-text p')
const input = document.querySelector('.wrapper .input-firld')
const time = document.querySelector('.time span b')
const mistakes = document.querySelector('.mistake span')
const wpm = document.querySelector('.wpm span')
const cpm = document.querySelector('.cpm span')
const btn = document.querySelector('button')

//set values

let timer;
let maxTime = 300;
let timeLeft = maxTime;
let charIndex = 0;
let mistake = 0;
let isTyping =false;

function loadParagraph(){
    const paragraph = [
        "I love to paint. It is my hobby. I paint with water colours. I like to paint beautiful landscapes. When we go on holidays to different places like hill "
        +"stations, desert areas, river banks or the countryside, I always take my art material with me. I like to sit and paint a scenery as I watch it. "
        +"The painting then is very vivid and comes alive. I find my hobby refreshing to me. I keep all my paintings carefully. "
        +"I have participated in different art exhibitions and painting competitions at school and at state level events, and won prizes too.",

        "I love to read. Reading is my hobby. I read books belonging to all genres. But it is adventure and mystery stories that keep me the most engaged. "
        +"I enjoy reading Sherlock Holmes stories by Arthur Conan Doyle. They are fascinating stories that keep me very captivated. I can read them over and over again "
        +"and I enjoy them. I also love to read the Harry Potter series of books by J.K Rowling. She has woven so much magic through her stories. I also liked reading "
        +"books by Enid Blyton. I am now starting to read Lord of the Rings by JRR Tolkien. It will be very fascinating to read the high-fantasy book. I always write "
        +"a review to a book once I finish reading it. It is an interesting exercise to do. It helps me to briefly write about what I liked and enjoyed or disliked about the book.",
        "A friend in need is a friend indeed! A true friend will be one who will stay by your side at all times. A real friend stays by you through thick and thin. A "
        +"true friend should be cherished and whose friendship should be safeguarded. Losing a true friend is like losing a treasure. And you may never recover the "
        +"wealth you lose. A true friend is difficult to come by. So value the friendship of such a friend. Most of all, reciprocate the love your friend has for you. "
        +"And give your friend a special place in your heart.",

        "Love is not love/ that alters when it alteration finds. So wrote Shakespeare. Your true friend loves you come what may. It is the love and friendship your "
        +"friend has for you that matter most. Any change of circumstance matters little to the deep love shared. Friendship is to be treasured like a jewel. If jewels "
        +"are lost they can be replicated. But a true friend cannot be cloned. Value your friendship. It will pass the test of time. Once true, always true. Such is a "
        +"real friend. A true friend cares for you at all times. Even when the going is bad, your friend will stay with you with unwavering love and affection and as "
        +"much care and concern. Likewise, even if you are not in physical proximity with each other the friendship with a true friend does not wane. Space and time do "
        +"not matter in true friendship.",

        "India is our nation. It is located in the center of South Asia. In world, Republic of India is the seventh largest country by area and the second most populated "
        +"country after China. India takes honour in being the largest democracy in the world. India is a diverse country with diverse cultures, languages, climates and "
        +"geography. India is a federation under republic government governed under parliamentary system. There are twenty nine states and seven union territories in India. "
        +"The national capital of India is Delhi. India is well known for its rich culture and cuisines, diverse wildlife, flora and fauna as well as for its genius "
        +"minds that have made us proud around the globe.",

        "India is a vast country with second highest population in the world. It is a country with diverse cultures, traditions and beliefs. People in India celebrate "
        +"unity in diversity. Festivals like Diwali, Holi, Navratri, Ramzan, Christmas etc. are celebrated by people across India and create a sense of brotherhood and "
        +"cultural unity. Each festival has its religious and cultural importance. India is the land of diverse people belonging to various religions and speaking "
        +"different languages. Our national language is Hindi. However, there are 22 different official languages spoken in India. It is the birth place of religions "
        +"such as Hinduism, Buddhism, Jainism, and Sikhism. People in India have diverse dressing styles, different food habits and customs that differ from place to "
        +"place. Indian cuisine is famous across the world. People with different castes, creed, colour, cultures and customs live in harmony in this India. It is a "
        +"perfect example of unity in diversity."
    ];

        const randumIndex = Math.floor(Math.random()*paragraph.length);
        typingtext.innerHTML='';
        for(const char of paragraph[randumIndex]){
            console.log(char);
            typingtext.innerHTML+= `<span>${char}</span>`;

            typingtext.querySelectorAll('span')[0].classList.add('active');

            document.addEventListener('keydown',()=>input.focus());
        }
}

//Handel user input

function initTyping(){
    const char = typingtext.querySelectorAll('span');
    const typedChar = input.value.charAt(charIndex);
    if(charIndex < char.length && timeLeft > 0){

        if(!isTyping){
            timer = setInterval(initTime,1000);
            isTyping = true;
        }

        if(char[charIndex].innerText === typedChar){
            char[charIndex].classList.add('correct');
            console.log('correct');
            
        }else{
            mistake++;
            char[charIndex].classList.add('incorrect');
            console.log('incorrect');
        }
        charIndex++;
        char[charIndex].classList.add('active');
        mistakes.innerHTML = mistake;
        cpm.innerText = charIndex-mistake;
    }else{
        clearInterval(timer);
        input.value=''
        
    }
}

function initTime(){
    if(timeLeft>0){
        timeLeft--;
        time.innerText = timeLeft;

        const wpmval = Math.round(((charIndex-mistake)/5)/(maxTime - timeLeft)*60);
        wpm.innerText = wpmval;
    }else{
        clearInterval(timer);
    }
}

function reset(){
    loadParagraph();
    clearInterval(timer);
    time.innerText = timeLeft;
    input.value = '';
    timeLeft = maxTime;
    charIndex = 0;
    mistake = 0;
    isTyping =false;
    wpm.innerText = 0;
    cpm.innerText = 0;
    mistakes.innerText = 0;

}

input.addEventListener("input",initTyping);
btn.addEventListener("click",reset);
loadParagraph();