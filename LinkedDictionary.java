package linkedDictionary;

import java.util.NoSuchElementException;

public class LinkedDictionary implements Map<String, Token> {
    Elem head;
    
		private static class Elem {
		String key;
		Token value;
		Elem next;
		public Elem (String key, Token val, Elem next)
		{
			this.key=key;
			value=val;
			this.next=next;
		}
	}

		@Override
		public Token get(String key) throws NoSuchElementException {
			// TODO Auto-generated method stub
			if ( key==null)
			{
				throw new NullPointerException();
			}
			if (head==null)
			{
				throw new NoSuchElementException();
			}
			/*if (head.key==null)
			{
				throw new NoSuchElementException();
			}
			*/
			else
			{
				Elem p= head;
				if (p.key.equals(key))
				{
					return p.value;
				}
				while (p.next!=null)
				{
					if (p.next.key.equals(key))
					{
						return p.next.value;
					}
						p=p.next;
				}
				throw new NoSuchElementException();
			}
		}

		@Override
		public boolean contains(String key) {
			if (key==null)
			{
				throw new NullPointerException();
			}
			if (head==null)
			{
				return false;
			}
			else
			{
				Elem p= head;
				while (p!=null)
				{
					if (p.key.equals(key))
					{
						return true;
					}
						p=p.next;
				}
				return false;
			}
		}

		@Override
		public void put(String key, Token value) {
			if (key==null)
			{
				throw new NullPointerException();
			}
			head= new Elem (key, value, head);
			// TODO Auto-generated method stub
			
		}

		@Override
		public void replace(String key, Token value)
				throws NoSuchElementException {
			if (key==null)
			{
				throw new NullPointerException();
			}
			if (contains(key))
			{
				System.out.print("contains true");
				Elem p= head;
				if (p.key.equals(key))
				{
					p.value=value;
				}
				while (p.next!=null)
				{
					if (p.next.key.equals(key))
					{
						p.next.value=value;
					}
						p=p.next;
				}
			}
			else 
				
			{
				System.out.print("contains false");
				throw new NoSuchElementException();
			}
			
		}

		@Override
		public Token remove(String key) throws NoSuchElementException {
			// TODO Auto-generated method stub
			if (key ==null)
			{
				throw new NullPointerException();
			}
			if (contains(key))
			{
				if (head.key.equals(key))
				{
					Token removed=head.value;
					head= head.next;
					return removed;
					
				}
				Elem p= head;
				while (p.next!=null)
				{
					if (p.next.key.equals(key))
					{
						Token removed=p.next.value;
						p.next=p.next.next;
						return removed;
					}
						p=p.next;
				}
				throw new NoSuchElementException();
			}
			else
			{
				throw new NoSuchElementException();
			}
				
	
		}

}
