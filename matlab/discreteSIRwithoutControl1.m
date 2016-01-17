function [y,k]=discreteSIRwithoutControl1(LAMBDA,beta,mu,d,r,S0,I0,R0,A)

test=-1;

n=100;
delta=0.00001;
t=linspace(0,100,n+1);
k=0;              

S=zeros(1,n+1);
S(1)=S0;
I=zeros(1,n+1);
I(1)=I0;
R=zeros(1,n+1);
R(1)=R0;
N=zeros(1,n+1);
N(1)=S0+I0+R0;

lambda1=zeros(1,n+1);
lambda2=zeros(1,n+1);
lambda2(n+1)=A;
lambda3=zeros(1,n+1);

while(test<0)
    
    oldS=S;
    oldI=I;
    oldR=R;
    
    oldlambda1=lambda1;
    oldlambda2=lambda2;
    oldlambda3=lambda3;
    
    k=k+1;
    
    for i=1:n
       S(i+1)=LAMBDA-(mu-1)*S(i)-beta*S(i)*I(i)/(N(i));
       I(i+1)=beta*S(i+1)*I(i)/(N(i))-(mu+d+r-1)*I(i);
       R(i+1)=r*I(i+1)-(mu-1)*R(i);
       N(i+1)=S(i+1)+I(i+1)+R(i+1);
    end
    
    for i=1:n
       lambda1(n-i+1)=-(mu-1)*lambda1(n-i+2)+beta*(I(i+1)/N(i+1))*(lambda2(n-i+2)-lambda1(n-i+2));
       lambda2(n-i+1)=A+beta*(S(i+1)/N(i+1))*(lambda2(n-i+2)-lambda1(n-i+1))-(mu+d+r-1)*lambda2(n-i+2)+r*lambda3(n-i+2);
       lambda3(n-i+1)=-(mu-1)*lambda3(n-i+2);
    end
    
    temp1=delta*sum(abs(S))-sum(abs(oldS-S));
    temp2=delta*sum(abs(I))-sum(abs(oldI-I));
    temp3=delta*sum(abs(R))-sum(abs(oldR-R));
    
    temp4=delta*sum(abs(lambda1))-sum(abs(oldlambda1-lambda1));
    temp5=delta*sum(abs(lambda2))-sum(abs(oldlambda2-lambda2));
    temp6=delta*sum(abs(lambda3))-sum(abs(oldlambda3-lambda3));
    
    test=min(temp1,min(temp2,min(temp3,min(temp4,min(temp5,temp6)))));
end

y(1,:)=t;
y(2,:)=S;
y(3,:)=I;
y(4,:)=R;
y(5,:)=lambda1;
y(6,:)=lambda2;
y(7,:)=lambda3;

subplot(3,1,1)
plot(y(1,:),y(3,:))
ylabel({'I(k)'})
xlabel('Time(days)')
hold all
subplot(3,1,2)
plot(y(1,:),y(2,:))
ylabel({'S(k)'})
xlabel('Time(days)')
hold all
subplot(3,1,3)
plot(y(1,:),y(4,:))
ylabel({'R(k)'})
xlabel('Time(days)')
hold all