package bean;

public class BidBean {
		int User_id;
		int Bid_id;
		int Project_id;
		private int accepted,escrow_indicator;
		int Amount;
		public int getUser_id()
		{
			return User_id;
		}
		public void setUser_id(int User_id)
		{
			this.User_id = User_id;
		}
		public int getBid_id()
		{
			return Bid_id;
		}
		public void setBid_id(int Bid_id)
		{
			this.Bid_id = Bid_id;
		}
		public int getProject_id()
		{
			return Project_id;
		}
		public void setProject_id(int Project_id)
		{
			this.Project_id = Project_id;
		}
		public int getaccepted()
		{
			return accepted;
		}
		public void setaccepted(int accepted)
		{
			this.accepted = accepted;
		}
		public int getAmount()
		{
			return Amount;
		}
		public void setAmount(int Amount)
		{
			this.Amount = Amount;
		}
		public int getescrow_indicator()
		{
			return escrow_indicator;
		}
		public void setescrow_indicator(int escrow_indicator)
		{
			this.escrow_indicator = escrow_indicator;
		}
	}
