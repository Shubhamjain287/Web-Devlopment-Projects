import React from "react";

const Card = (prop) => {
  return (
    <div>
      <div className="Card">
        <div className="Cards">
          <img src={prop.imgsrc} alt="User Image" className="Cards_img" />
          <div className="Card_info">
            <span className="Card_Cat"> {prop.Description} </span>
            <h3 className="Card_tittle"> {prop.Name}</h3>
            <a href={prop.github} target="_blank">
              <button> Github Link </button>
            </a>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Card;
