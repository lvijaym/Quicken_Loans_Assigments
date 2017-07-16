def quicksort(a,low,high):
	if (low < high):
		p = partition(a,low,high)   # get pivot
		quicksort(a,low,p)      # apply quick sort on smaller elements
		quicksort(a,p+1,high)	# apply quick sort on larger elements
	return a

def partition(a,lo,hi):
	pivot = a[hi-1]
	i = lo
	for j in xrange(lo, hi-1):
		if (a[j] <= pivot):
			x = a[i]
			a[i] = a[j]
			a[j] =x
			i = i+1
	y = a[i]
	a[i] = pivot
	a[hi-1] = y
	return i
	
l = ["Vijay","Anu","Krishnaja","Mittu","Akhil"]
final = quicksort(l,0,len(l))	
print "sorted list is ", final