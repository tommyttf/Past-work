%matlab R2013a
function c = slowmultiply(a,b)

[M,N]=size(a);

c=zeros(1,2*N-1);
for m=1:2*N-1
    if m<=N
        for k=1:m
            c(m)=c(m)+a(k)*b(m-k+1);
        end
    else
        for k=m-N+1:N
            c(m)=c(m)+a(k)*b(m-k+1);
        end
    end
end
