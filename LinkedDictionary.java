package linkedDictionary;

import java.util.NoSuchElementException;

public class LinkedDictionary implements Map<String, Token> {
    Elem head;
    
		public class Elem {
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
			if (head.key==null || key==null)
			{
				throw new NoSuchElementException();
			}
			else
			{
				Elem p= head;
				while (p.key!=null)
				{
					if (p.key== key)
					{
						return p.value;
					}
						p=p.next;
				}
				throw new NoSuchElementException();
			}
		}

		@Override
		public boolean contains(String key) {
			if (head.key==null)
			{
				return false;
			}
			else
			{
				Elem p= head;
				while (p.key!=null)
				{
					if (p.key== key)
					{
						return true;
					}
						p=p.next;
				}
			}
			return false;
		}

		@Override
		public void put(String key, Token value) {
			head= new Elem (key, value, head);
			// TODO Auto-generated method stub
			
		}

		@Override
		public void replace(String key, Token value)
				throws NoSuchElementException {
			if (contains(key))
			{
				System.out.print("contains true");
				Elem p= head;
				while (p.key!=null)
				{
					if (p.key== key)
					{
						p.value=value;
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
			if (contains(key))
			{
				if (head.key==key)
				{
					Token removed=head.value;
					head= head.next;
					return removed;
					
				}
				Elem p= head;
				while (p.next!=null)
				{
					if (p.next.key== key)
					{
						Token removed=p.next.value;
						p.next=p.next.next;
						return removed;
					}
						p=p.next;
				}
			}
			else
			{
				throw new NoSuchElementException();
			}
			return null;
		}

}
