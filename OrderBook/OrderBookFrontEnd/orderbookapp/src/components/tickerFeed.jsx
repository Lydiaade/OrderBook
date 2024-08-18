import React, { Component } from "react";
import Ticker from "react-ticker";

class TickerFeed extends Component {
  state = {};
  render() {
    let trades = this.compileListOfTrades();
    console.log(this.props.tickerFeedTrades[0]);
    return (
      <div>
        <br />
        <br />
        <div className="fixed-bottom tickerFeed">
          <Ticker mode="await" speed="20">
            {() => <h4>{this.props.tickerFeedTrades[0].price}</h4>}
          </Ticker>
        </div>
      </div>
    );
  }
  compileListOfTrades = () => {
    let tradeStatement = "          ";
    this.props.tickerFeedTrades.map((trade) => console.log(trade));
    return tradeStatement;
  };
}

export default TickerFeed;

/*
tradeStatement.concat(
        trade.buyOrder.stock.symbol + " " + trade.price + "         |         "
      )
      */
